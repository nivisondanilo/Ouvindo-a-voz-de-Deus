package com.example.calendar

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import com.example.i18n.AppLanguage
import com.example.model.ReadingPlan
import java.util.Calendar

object CalendarSyncHelper {
    fun launchDailyPlanCalendarEvent(
        context: Context,
        plan: ReadingPlan,
        hour: Int,
        minute: Int,
        language: AppLanguage
    ): Boolean {
        val startCal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour.coerceIn(0, 23))
            set(Calendar.MINUTE, minute.coerceIn(0, 59))
            set(Calendar.SECOND, 0)
            if (timeInMillis <= System.currentTimeMillis()) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }
        val endMillis = startCal.timeInMillis + 15 * 60 * 1000L

        val title = when (language) {
            AppLanguage.PT -> "Estudo Bíblico: ${plan.title(language)}"
            AppLanguage.EN -> "Bible Study: ${plan.title(language)}"
            AppLanguage.ES -> "Estudio Bíblico: ${plan.title(language)}"
        }
        val description = when (language) {
            AppLanguage.PT -> "Ouvindo a Voz de Deus — ${plan.subtitle(language)}"
            AppLanguage.EN -> "Hearing God's Voice — ${plan.subtitle(language)}"
            AppLanguage.ES -> "Oyendo la Voz de Dios — ${plan.subtitle(language)}"
        }

        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.DESCRIPTION, description)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startCal.timeInMillis)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
            putExtra(CalendarContract.Events.RRULE, "FREQ=DAILY;COUNT=${plan.days.size}")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        return try {
            context.startActivity(intent)
            true
        } catch (_: Exception) {
            false
        }
    }
}
