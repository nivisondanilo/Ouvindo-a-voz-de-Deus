package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.i18n.AppLanguage
import com.example.ui.theme.ReadingThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.userPrefsDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "voz_de_deus_prefs"
)

data class UserPreferencesState(
    val language: AppLanguage = AppLanguage.PT,
    val themeMode: ReadingThemeMode = ReadingThemeMode.DAY,
    val fontScale: Float = 1.0f,
    val ttsSpeed: Float = 1.0f,
    val reminderEnabled: Boolean = true,
    val reminderHour: Int = 19,
    val reminderMinute: Int = 0,
    val xp: Int = 0,
    val streakDays: Int = 1,
    val lastStudyDateIso: String = "",
    val unlockedBadges: Set<String> = emptySet(),
    val selectedPlanId: String = "plan_7",
    val displayName: String = "Explorador",
    val totalStudySeconds: Long = 0L,
    val lastLessonNumber: Int = 1,
    val lastRoute: String = "home",
    val answeredOptions: Map<String, Int> = emptyMap()
)

class UserPreferencesRepository(private val context: Context) {
    private object Keys {
        val LANGUAGE = stringPreferencesKey("language")
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val FONT_SCALE = floatPreferencesKey("font_scale")
        val TTS_SPEED = floatPreferencesKey("tts_speed")
        val REMINDER_ENABLED = booleanPreferencesKey("reminder_enabled")
        val REMINDER_HOUR = intPreferencesKey("reminder_hour")
        val REMINDER_MINUTE = intPreferencesKey("reminder_minute")
        val XP = intPreferencesKey("xp")
        val STREAK_DAYS = intPreferencesKey("streak_days")
        val LAST_STUDY_DATE = stringPreferencesKey("last_study_date")
        val UNLOCKED_BADGES = stringSetPreferencesKey("unlocked_badges")
        val SELECTED_PLAN_ID = stringPreferencesKey("selected_plan_id")
        val DISPLAY_NAME = stringPreferencesKey("display_name")
        val TOTAL_STUDY_SECONDS = longPreferencesKey("total_study_seconds")
        val LAST_LESSON_NUMBER = intPreferencesKey("last_lesson_number")
        val LAST_ROUTE = stringPreferencesKey("last_route")
        val ANSWERED_OPTIONS = stringPreferencesKey("answered_options")
    }

    val preferencesFlow: Flow<UserPreferencesState> = context.userPrefsDataStore.data.map { prefs ->
        UserPreferencesState(
            language = AppLanguage.fromCode(prefs[Keys.LANGUAGE]),
            themeMode = ReadingThemeMode.fromId(prefs[Keys.THEME_MODE]),
            fontScale = prefs[Keys.FONT_SCALE] ?: 1.0f,
            ttsSpeed = prefs[Keys.TTS_SPEED] ?: 1.0f,
            reminderEnabled = prefs[Keys.REMINDER_ENABLED] ?: true,
            reminderHour = prefs[Keys.REMINDER_HOUR] ?: 19,
            reminderMinute = prefs[Keys.REMINDER_MINUTE] ?: 0,
            xp = prefs[Keys.XP] ?: 0,
            streakDays = prefs[Keys.STREAK_DAYS] ?: 1,
            lastStudyDateIso = prefs[Keys.LAST_STUDY_DATE] ?: "",
            unlockedBadges = prefs[Keys.UNLOCKED_BADGES] ?: emptySet(),
            selectedPlanId = prefs[Keys.SELECTED_PLAN_ID] ?: "plan_7",
            displayName = prefs[Keys.DISPLAY_NAME] ?: "Explorador",
            totalStudySeconds = prefs[Keys.TOTAL_STUDY_SECONDS] ?: 0L,
            lastLessonNumber = (prefs[Keys.LAST_LESSON_NUMBER] ?: 1).coerceIn(1, 27),
            lastRoute = prefs[Keys.LAST_ROUTE] ?: "home",
            answeredOptions = decodeAnsweredOptions(prefs[Keys.ANSWERED_OPTIONS])
        )
    }

    suspend fun getInitialResumeState(): Pair<String, Int> {
        val prefs = context.userPrefsDataStore.data.first()
        val route = prefs[Keys.LAST_ROUTE] ?: "home"
        val lesson = (prefs[Keys.LAST_LESSON_NUMBER] ?: 1).coerceIn(1, 27)
        return route to lesson
    }

    suspend fun setLanguage(language: AppLanguage) {
        context.userPrefsDataStore.edit { it[Keys.LANGUAGE] = language.code }
    }

    suspend fun setThemeMode(mode: ReadingThemeMode) {
        context.userPrefsDataStore.edit { it[Keys.THEME_MODE] = mode.id }
    }

    suspend fun setFontScale(scale: Float) {
        context.userPrefsDataStore.edit { it[Keys.FONT_SCALE] = scale.coerceIn(0.85f, 1.35f) }
    }

    suspend fun setTtsSpeed(speed: Float) {
        context.userPrefsDataStore.edit { it[Keys.TTS_SPEED] = speed.coerceIn(0.75f, 1.4f) }
    }

    suspend fun setReminderConfig(enabled: Boolean, hour: Int, minute: Int) {
        context.userPrefsDataStore.edit {
            it[Keys.REMINDER_ENABLED] = enabled
            it[Keys.REMINDER_HOUR] = hour.coerceIn(0, 23)
            it[Keys.REMINDER_MINUTE] = minute.coerceIn(0, 59)
        }
    }

    suspend fun setSelectedPlanId(planId: String) {
        context.userPrefsDataStore.edit { it[Keys.SELECTED_PLAN_ID] = planId }
    }

    suspend fun setLastPosition(route: String, lessonNumber: Int? = null) {
        context.userPrefsDataStore.edit { prefs ->
            prefs[Keys.LAST_ROUTE] = route
            if (lessonNumber != null) {
                prefs[Keys.LAST_LESSON_NUMBER] = lessonNumber.coerceIn(1, 27)
            }
        }
    }

    suspend fun saveThoughtAnswer(lessonNumber: Int, stepNumber: Int, optionIndex: Int) {
        val key = "${lessonNumber}_$stepNumber"
        context.userPrefsDataStore.edit { prefs ->
            val map = decodeAnsweredOptions(prefs[Keys.ANSWERED_OPTIONS]).toMutableMap()
            map[key] = optionIndex
            prefs[Keys.ANSWERED_OPTIONS] = encodeAnsweredOptions(map)
            prefs[Keys.LAST_LESSON_NUMBER] = lessonNumber.coerceIn(1, 27)
        }
    }

    suspend fun clearLessonAnswers(lessonNumber: Int) {
        val prefix = "${lessonNumber}_"
        context.userPrefsDataStore.edit { prefs ->
            val filtered = decodeAnsweredOptions(prefs[Keys.ANSWERED_OPTIONS])
                .filterKeys { !it.startsWith(prefix) }
            prefs[Keys.ANSWERED_OPTIONS] = encodeAnsweredOptions(filtered)
        }
    }

    suspend fun addXpAndBadges(xpDelta: Int, newBadges: Set<String>) {
        context.userPrefsDataStore.edit { prefs ->
            val currentXp = prefs[Keys.XP] ?: 0
            prefs[Keys.XP] = (currentXp + xpDelta).coerceAtLeast(0)
            if (newBadges.isNotEmpty()) {
                val existing = prefs[Keys.UNLOCKED_BADGES] ?: emptySet()
                prefs[Keys.UNLOCKED_BADGES] = existing + newBadges
            }
        }
    }

    suspend fun recordStudyActivity(todayIso: String, yesterdayIso: String, secondsDelta: Long) {
        context.userPrefsDataStore.edit { prefs ->
            val currentSec = prefs[Keys.TOTAL_STUDY_SECONDS] ?: 0L
            prefs[Keys.TOTAL_STUDY_SECONDS] = currentSec + secondsDelta.coerceAtLeast(0L)
            val lastDate = prefs[Keys.LAST_STUDY_DATE] ?: ""
            val currentStreak = prefs[Keys.STREAK_DAYS] ?: 0
            when (lastDate) {
                todayIso -> if (currentStreak == 0) prefs[Keys.STREAK_DAYS] = 1
                yesterdayIso -> prefs[Keys.STREAK_DAYS] = currentStreak + 1
                else -> prefs[Keys.STREAK_DAYS] = 1
            }
            prefs[Keys.LAST_STUDY_DATE] = todayIso
        }
    }

    private fun decodeAnsweredOptions(raw: String?): Map<String, Int> {
        if (raw.isNullOrBlank()) return emptyMap()
        return raw.split(";")
            .mapNotNull { entry ->
                val parts = entry.split("=")
                if (parts.size == 2) {
                    val idx = parts[1].toIntOrNull()
                    if (idx != null) parts[0] to idx else null
                } else null
            }
            .toMap()
    }

    private fun encodeAnsweredOptions(map: Map<String, Int>): String =
        map.entries.joinToString(";") { "${it.key}=${it.value}" }
}
