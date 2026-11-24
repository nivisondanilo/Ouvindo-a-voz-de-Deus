package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.content.OfflineBibleRepository
import com.example.data.content.StudyCatalog
import com.example.data.local.DailyStudyLog
import com.example.data.local.LocalBibleNote
import com.example.data.local.LocalLessonProgress
import com.example.data.local.LocalPlanDay
import com.example.data.local.StudyDao
import com.example.data.local.UserPreferencesRepository
import com.example.data.local.UserPreferencesState
import com.example.i18n.AppLanguage
import com.example.model.StudyCategory
import com.example.ui.theme.ReadingThemeMode
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class StudyDashboardState(
    val prefs: UserPreferencesState = UserPreferencesState(),
    val lessonProgressMap: Map<Int, LocalLessonProgress> = emptyMap(),
    val notes: List<LocalBibleNote> = emptyList(),
    val recentLogs: List<DailyStudyLog> = emptyList(),
    val completedPlanDays: Set<Int> = emptySet(),
    val statusBannerMessage: String? = null
) {
    val completedLessonCount: Int
        get() = lessonProgressMap.values.count { it.completed }

    val resumeLessonNumber: Int
        get() = prefs.lastLessonNumber.coerceIn(1, 27)

    val quizAccuracyPercent: Int
        get() {
            val attempted = lessonProgressMap.values.filter { it.quizTotal > 0 }
            if (attempted.isEmpty()) return 0
            val correct = attempted.sumOf { it.quizScore }
            val total = attempted.sumOf { it.quizTotal }
            return if (total > 0) ((correct * 100f) / total).toInt().coerceIn(0, 100) else 0
        }
}

class MainViewModel(
    private val studyDao: StudyDao,
    private val prefsRepo: UserPreferencesRepository
) : ViewModel() {

    private val _statusBanner = MutableStateFlow<String?>(null)
    val statusBanner: StateFlow<String?> = _statusBanner.asStateFlow()

    private var activeStudyTicker: Job? = null
    private var activeLessonTracking: Int? = null

    private val selectedPlanIdFlow = MutableStateFlow("plan_7")

    init {
        viewModelScope.launch {
            prefsRepo.preferencesFlow.collect { prefs ->
                selectedPlanIdFlow.value = prefs.selectedPlanId
            }
        }
    }

    private val planDaysFlow = combine(
        selectedPlanIdFlow,
        studyDao.observePlanDays("plan_7"),
        studyDao.observePlanDays("plan_14"),
        studyDao.observePlanDays("plan_27")
    ) { planId, p7, p14, p27 ->
        when (planId) {
            "plan_14" -> p14
            "plan_27" -> p27
            else -> p7
        }.filter { it.completed }.map { it.dayNumber }.toSet()
    }

    val uiState: StateFlow<StudyDashboardState> = combine(
        prefsRepo.preferencesFlow,
        studyDao.observeLessonProgress(),
        studyDao.observeBibleNotes(),
        studyDao.observeRecentStudyLogs(),
        planDaysFlow,
        _statusBanner
    ) { values ->
        val prefs = values[0] as UserPreferencesState
        @Suppress("UNCHECKED_CAST")
        val lessons = values[1] as List<LocalLessonProgress>
        @Suppress("UNCHECKED_CAST")
        val notes = values[2] as List<LocalBibleNote>
        @Suppress("UNCHECKED_CAST")
        val logs = values[3] as List<DailyStudyLog>
        @Suppress("UNCHECKED_CAST")
        val planDays = values[4] as Set<Int>
        val banner = values[5] as String?

        StudyDashboardState(
            prefs = prefs,
            lessonProgressMap = lessons.associateBy { it.lessonNumber },
            notes = notes,
            recentLogs = logs,
            completedPlanDays = planDays,
            statusBannerMessage = banner
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = StudyDashboardState()
    )

    fun recordLastPosition(route: String, lessonNumber: Int? = null) {
        viewModelScope.launch {
            prefsRepo.setLastPosition(route, lessonNumber)
        }
    }

    fun startStudyTimer(lessonNumber: Int? = null) {
        activeLessonTracking = lessonNumber
        if (activeStudyTicker?.isActive == true) return
        activeStudyTicker = viewModelScope.launch {
            while (isActive) {
                delay(15_000L)
                recordStudySeconds(15L, activeLessonTracking)
            }
        }
    }

    fun stopStudyTimer() {
        activeStudyTicker?.cancel()
        activeStudyTicker = null
        activeLessonTracking = null
    }

    private suspend fun recordStudySeconds(seconds: Long, lessonNumber: Int?) {
        val today = todayIso()
        val yesterday = yesterdayIso()
        prefsRepo.recordStudyActivity(today, yesterday, seconds)

        val currentLog = studyDao.getStudyLog(today)
        studyDao.upsertStudyLog(
            DailyStudyLog(
                dateIso = today,
                studySeconds = (currentLog?.studySeconds ?: 0L) + seconds,
                lessonsTouched = currentLog?.lessonsTouched ?: 0
            )
        )

        if (lessonNumber != null) {
            val existing = studyDao.getLessonProgress(lessonNumber)
                ?: LocalLessonProgress(lessonNumber = lessonNumber)
            studyDao.upsertLessonProgress(
                existing.copy(
                    studySeconds = existing.studySeconds + seconds,
                    updatedAtMillis = System.currentTimeMillis()
                )
            )
        }
    }

    fun answerThoughtQuestion(lessonNumber: Int, stepNumber: Int, selectedIndex: Int) {
        viewModelScope.launch {
            val key = "${lessonNumber}_$stepNumber"
            val previous = uiState.value.prefs.answeredOptions[key]
            if (previous != null) return@launch

            prefsRepo.saveThoughtAnswer(lessonNumber, stepNumber, selectedIndex)

            val lesson = StudyCatalog.getLesson(lessonNumber)
            val block = lesson.thoughtBlocks.firstOrNull { it.stepNumber == stepNumber } ?: return@launch
            val isCorrect = selectedIndex == block.question.correctIndex
            val xpGain = if (isCorrect) 25 else 10

            val updatedAnswers = uiState.value.prefs.answeredOptions + (key to selectedIndex)
            val correctCount = lesson.thoughtBlocks.count { tb ->
                updatedAnswers["${lessonNumber}_${tb.stepNumber}"] == tb.question.correctIndex
            }
            val answeredCount = lesson.thoughtBlocks.count { tb ->
                updatedAnswers.containsKey("${lessonNumber}_${tb.stepNumber}")
            }
            val allAnswered = answeredCount >= lesson.thoughtBlocks.size

            val existing = studyDao.getLessonProgress(lessonNumber)
            val completedNow = (existing?.completed == true) || allAnswered
            studyDao.upsertLessonProgress(
                (existing ?: LocalLessonProgress(lessonNumber = lessonNumber)).copy(
                    completed = completedNow,
                    quizScore = maxOf(existing?.quizScore ?: 0, correctCount),
                    quizTotal = lesson.thoughtBlocks.size,
                    updatedAtMillis = System.currentTimeMillis()
                )
            )
            recordStudySeconds(20L, lessonNumber)
            evaluateAndAwardBadges(xpGain)
        }
    }

    fun markReadingCompleted(lessonNumber: Int) {
        viewModelScope.launch {
            val lesson = StudyCatalog.getLesson(lessonNumber)
            val existing = studyDao.getLessonProgress(lessonNumber)
            val alreadyCompleted = existing?.completed == true
            val answers = uiState.value.prefs.answeredOptions
            val correctCount = lesson.thoughtBlocks.count { tb ->
                answers["${lessonNumber}_${tb.stepNumber}"] == tb.question.correctIndex
            }
            val updated = (existing ?: LocalLessonProgress(lessonNumber = lessonNumber)).copy(
                completed = true,
                quizScore = maxOf(existing?.quizScore ?: 0, correctCount),
                quizTotal = lesson.thoughtBlocks.size,
                updatedAtMillis = System.currentTimeMillis()
            )
            studyDao.upsertLessonProgress(updated)
            recordStudySeconds(60L, lessonNumber)
            val xpReward = if (alreadyCompleted) 20 else lesson.xpReward
            evaluateAndAwardBadges(xpReward)
        }
    }

    private suspend fun evaluateAndAwardBadges(baseXp: Int) {
        val allLessons = studyDao.getAllLessonProgress()
        val notes = studyDao.getAllBibleNotes()
        val prefs = uiState.value.prefs

        val completedNums = allLessons.filter { it.completed }.map { it.lessonNumber }.toSet()
        val newBadges = mutableSetOf<String>()

        if (completedNums.isNotEmpty() && "first_step" !in prefs.unlockedBadges) {
            newBadges.add("first_step")
        }
        if (prefs.streakDays >= 3 && "streak_3" !in prefs.unlockedBadges) {
            newBadges.add("streak_3")
        }
        val foundationsCount = StudyCatalog.allLessons.count {
            it.category == StudyCategory.FOUNDATIONS && it.number in completedNums
        }
        if (foundationsCount >= 5 && "foundations_master" !in prefs.unlockedBadges) {
            newBadges.add("foundations_master")
        }
        val prophecyCount = StudyCatalog.allLessons.count {
            it.category == StudyCategory.PROPHECY && it.number in completedNums
        }
        if (prophecyCount >= 3 && "prophecy_scout" !in prefs.unlockedBadges) {
            newBadges.add("prophecy_scout")
        }
        if (notes.size >= 3 && "note_keeper" !in prefs.unlockedBadges) {
            newBadges.add("note_keeper")
        }
        val perfectQuizzes = allLessons.count { it.quizTotal > 0 && it.quizScore >= it.quizTotal }
        if (perfectQuizzes >= 5 && "quiz_ace" !in prefs.unlockedBadges) {
            newBadges.add("quiz_ace")
        }
        if (completedNums.size >= 14 && "halfway_hero" !in prefs.unlockedBadges) {
            newBadges.add("halfway_hero")
        }
        if (completedNums.size >= 27 && "voice_ambassador" !in prefs.unlockedBadges) {
            newBadges.add("voice_ambassador")
        }

        val badgeBonusXp = newBadges.sumOf { id ->
            StudyCatalog.badges.firstOrNull { it.id == id }?.xpBonus ?: 0
        }
        prefsRepo.addXpAndBadges(baseXp + badgeBonusXp, newBadges)
    }

    fun saveBibleNote(
        bookId: String,
        chapter: Int,
        verse: Int,
        noteText: String,
        highlightColor: String
    ) {
        if (noteText.isBlank() && highlightColor == "none") return
        viewModelScope.launch {
            val lang = uiState.value.prefs.language
            val bookName = OfflineBibleRepository.bookName(OfflineBibleRepository.getBook(bookId), lang)
            val noteId = "${bookId}_${chapter}_${verse}"
            val safeText = noteText.trim().ifBlank {
                when (lang) {
                    AppLanguage.PT -> "Versículo destacado"
                    AppLanguage.EN -> "Highlighted verse"
                    AppLanguage.ES -> "Versículo resaltado"
                }
            }
            studyDao.upsertBibleNote(
                LocalBibleNote(
                    noteId = noteId,
                    bookId = bookId,
                    chapter = chapter,
                    verse = verse,
                    referenceLabel = "$bookName $chapter:$verse",
                    noteText = safeText.take(2000),
                    highlightColor = highlightColor,
                    updatedAtMillis = System.currentTimeMillis()
                )
            )
            evaluateAndAwardBadges(25)
        }
    }

    fun deleteBibleNote(noteId: String) {
        viewModelScope.launch {
            studyDao.deleteBibleNote(noteId)
        }
    }

    fun togglePlanDay(planId: String, dayNumber: Int, currentlyCompleted: Boolean) {
        viewModelScope.launch {
            val key = "${planId}_$dayNumber"
            if (currentlyCompleted) {
                studyDao.deletePlanDay(key)
            } else {
                studyDao.upsertPlanDay(
                    LocalPlanDay(
                        planDayKey = key,
                        planId = planId,
                        dayNumber = dayNumber,
                        completed = true
                    )
                )
                prefsRepo.addXpAndBadges(30, emptySet())
            }
        }
    }

    fun selectReadingPlan(planId: String) {
        viewModelScope.launch { prefsRepo.setSelectedPlanId(planId) }
    }

    fun setLanguage(language: AppLanguage) {
        viewModelScope.launch { prefsRepo.setLanguage(language) }
    }

    fun setThemeMode(mode: ReadingThemeMode) {
        viewModelScope.launch { prefsRepo.setThemeMode(mode) }
    }

    fun setFontScale(scale: Float) {
        viewModelScope.launch { prefsRepo.setFontScale(scale) }
    }

    fun setTtsSpeed(speed: Float) {
        viewModelScope.launch { prefsRepo.setTtsSpeed(speed) }
    }

    fun setReminderConfig(enabled: Boolean, hour: Int, minute: Int) {
        viewModelScope.launch { prefsRepo.setReminderConfig(enabled, hour, minute) }
    }

    fun setStatusBanner(message: String?) {
        _statusBanner.value = message
    }

    override fun onCleared() {
        super.onCleared()
        stopStudyTimer()
    }

    private fun todayIso(): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        return fmt.format(Calendar.getInstance().time)
    }

    private fun yesterdayIso(): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val cal = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -1) }
        return fmt.format(cal.time)
    }
}
