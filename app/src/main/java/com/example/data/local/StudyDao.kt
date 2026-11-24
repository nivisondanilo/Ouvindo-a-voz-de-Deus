package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyDao {
    @Query("SELECT * FROM lesson_progress ORDER BY lessonNumber ASC")
    fun observeLessonProgress(): Flow<List<LocalLessonProgress>>

    @Query("SELECT * FROM lesson_progress ORDER BY lessonNumber ASC")
    suspend fun getAllLessonProgress(): List<LocalLessonProgress>

    @Query("SELECT * FROM lesson_progress WHERE lessonNumber = :lessonNumber LIMIT 1")
    suspend fun getLessonProgress(lessonNumber: Int): LocalLessonProgress?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertLessonProgress(progress: LocalLessonProgress)

    @Query("SELECT * FROM bible_notes ORDER BY updatedAtMillis DESC")
    fun observeBibleNotes(): Flow<List<LocalBibleNote>>

    @Query("SELECT * FROM bible_notes ORDER BY updatedAtMillis DESC")
    suspend fun getAllBibleNotes(): List<LocalBibleNote>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertBibleNote(note: LocalBibleNote)

    @Query("DELETE FROM bible_notes WHERE noteId = :noteId")
    suspend fun deleteBibleNote(noteId: String)

    @Query("SELECT * FROM daily_study_logs ORDER BY dateIso DESC LIMIT 14")
    fun observeRecentStudyLogs(): Flow<List<DailyStudyLog>>

    @Query("SELECT * FROM daily_study_logs WHERE dateIso = :dateIso LIMIT 1")
    suspend fun getStudyLog(dateIso: String): DailyStudyLog?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStudyLog(log: DailyStudyLog)

    @Query("SELECT * FROM reading_plan_progress WHERE planId = :planId")
    fun observePlanDays(planId: String): Flow<List<LocalPlanDay>>

    @Query("SELECT * FROM reading_plan_progress")
    suspend fun getAllPlanDays(): List<LocalPlanDay>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPlanDay(day: LocalPlanDay)

    @Query("DELETE FROM reading_plan_progress WHERE planDayKey = :planDayKey")
    suspend fun deletePlanDay(planDayKey: String)
}
