package com.example.model

import com.example.i18n.AppLanguage

enum class StudyCategory(
    val ptLabel: String,
    val enLabel: String,
    val esLabel: String
) {
    FOUNDATIONS("Fundamentos da Fé", "Foundations of Faith", "Fundamentos de Fe"),
    PROPHECY("Profecias & Esperança", "Prophecy & Hope", "Profecías y Esperanza"),
    SANCTUARY("Graça & Santuário", "Grace & Sanctuary", "Gracia y Santuario"),
    CHRISTIAN_LIFE("Vida & Mandamentos", "Life & Commandments", "Vida y Mandamientos"),
    MISSION("Igreja & Missão", "Church & Mission", "Iglesia y Misión");

    fun label(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> ptLabel
        AppLanguage.EN -> enLabel
        AppLanguage.ES -> esLabel
    }
}

enum class StudyHeaderArt {
    HERO_STUDY,
    BIBLE_NIGHT,
    PROPHECY,
    BADGE_TROPHY
}

data class KeyVerseRef(
    val bookId: String,
    val chapter: Int,
    val verse: Int,
    val reference: String,
    val excerpt: String,
    val endVerse: Int? = null
)

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val verseRef: String
)

data class StudyThoughtBlock(
    val stepNumber: Int,
    val isReview: Boolean = false,
    val heading: String,
    val studyText: String,
    val bibleRefs: List<KeyVerseRef>,
    val question: QuizQuestion
)

data class StudyLesson(
    val number: Int,
    val title: String,
    val subtitle: String,
    val category: StudyCategory,
    val headerArt: StudyHeaderArt,
    val estimatedMinutes: Int,
    val xpReward: Int,
    val blogIntro: String,
    val thoughtBlocks: List<StudyThoughtBlock>,
    val motivationalMessage: String,
    val youtubePlaylistIndex: Int = number,
    val youtubeVideoTitle: String = title
) {
    val keyVerses: List<KeyVerseRef>
        get() = thoughtBlocks.flatMap { it.bibleRefs }.distinctBy { it.reference }

    val quiz: List<QuizQuestion>
        get() = thoughtBlocks.map { it.question }

    val totalStudyCharacters: Int
        get() = blogIntro.length + thoughtBlocks.sumOf { it.heading.length + it.studyText.length } + motivationalMessage.length
}

data class ReadingPlanDay(
    val dayNumber: Int,
    val title: String,
    val lessonNumber: Int,
    val bibleRef: String,
    val bookId: String,
    val chapter: Int
)

data class ReadingPlan(
    val id: String,
    val titlePt: String,
    val titleEn: String,
    val titleEs: String,
    val subtitlePt: String,
    val subtitleEn: String,
    val subtitleEs: String,
    val days: List<ReadingPlanDay>
) {
    fun title(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> titlePt
        AppLanguage.EN -> titleEn
        AppLanguage.ES -> titleEs
    }

    fun subtitle(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> subtitlePt
        AppLanguage.EN -> subtitleEn
        AppLanguage.ES -> subtitleEs
    }
}

data class BadgeDefinition(
    val id: String,
    val titlePt: String,
    val titleEn: String,
    val titleEs: String,
    val descPt: String,
    val descEn: String,
    val descEs: String,
    val xpBonus: Int
) {
    fun title(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> titlePt
        AppLanguage.EN -> titleEn
        AppLanguage.ES -> titleEs
    }

    fun description(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> descPt
        AppLanguage.EN -> descEn
        AppLanguage.ES -> descEs
    }
}

data class ExplorerLevel(
    val level: Int,
    val minXp: Int,
    val titlePt: String,
    val titleEn: String,
    val titleEs: String
) {
    fun title(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> titlePt
        AppLanguage.EN -> titleEn
        AppLanguage.ES -> titleEs
    }
}

data class DailyInspiration(
    val verseRef: String,
    val verseText: String,
    val motivationPt: String,
    val motivationEn: String,
    val motivationEs: String
) {
    fun motivation(lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> motivationPt
        AppLanguage.EN -> motivationEn
        AppLanguage.ES -> motivationEs
    }
}
