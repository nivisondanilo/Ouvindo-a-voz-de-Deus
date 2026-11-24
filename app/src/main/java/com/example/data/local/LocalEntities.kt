package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_progress")
data class LocalLessonProgress(
    @PrimaryKey val lessonNumber: Int,
    val completed: Boolean = false,
    val quizScore: Int = 0,
    val quizTotal: Int = 0,
    val studySeconds: Long = 0L,
    val updatedAtMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "bible_notes")
data class LocalBibleNote(
    @PrimaryKey val noteId: String,
    val bookId: String,
    val chapter: Int,
    val verse: Int,
    val referenceLabel: String,
    val noteText: String,
    val highlightColor: String = "gold",
    val updatedAtMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "daily_study_logs")
data class DailyStudyLog(
    @PrimaryKey val dateIso: String,
    val studySeconds: Long = 0L,
    val lessonsTouched: Int = 0
)

@Entity(tableName = "reading_plan_progress")
data class LocalPlanDay(
    @PrimaryKey val planDayKey: String,
    val planId: String,
    val dayNumber: Int,
    val completed: Boolean = true,
    val completedAtMillis: Long = System.currentTimeMillis()
)
