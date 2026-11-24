package com.example.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Contrast
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.i18n.AppLanguage
import com.example.i18n.AppStrings
import com.example.notifications.DailyReminderReceiver
import com.example.notifications.ReminderScheduler
import com.example.ui.StudyDashboardState
import com.example.ui.theme.LocalIsHighContrast
import com.example.ui.theme.ReadingThemeMode
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen(
    state: StudyDashboardState,
    strings: AppStrings,
    onSetLanguage: (AppLanguage) -> Unit,
    onSetThemeMode: (ReadingThemeMode) -> Unit,
    onSetFontScale: (Float) -> Unit,
    onSetTtsSpeed: (Float) -> Unit,
    onSetReminderConfig: (Boolean, Int, Int) -> Unit,
    onSyncCalendar: () -> Unit,
    onShowBanner: (String) -> Unit
) {
    val context = LocalContext.current
    val isHighContrast = LocalIsHighContrast.current
    val cardBorder = if (isHighContrast) BorderStroke(2.dp, MaterialTheme.colorScheme.outline) else null

    var showTimePicker by remember { mutableStateOf(false) }

    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            onSetReminderConfig(true, state.prefs.reminderHour, state.prefs.reminderMinute)
            ReminderScheduler.scheduleDailyReminder(
                context, true, state.prefs.reminderHour, state.prefs.reminderMinute, state.prefs.language
            )
            DailyReminderReceiver.showDailyStudyNotification(context, state.prefs.language)
            onShowBanner(strings.notificationSentMsg)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 840.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = strings.profileTitle,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // Multilingual Support
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    border = cardBorder,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Translate, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Text(strings.languageTitle, style = MaterialTheme.typography.titleMedium)
                        }
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(AppLanguage.entries) { lang ->
                                FilterChip(
                                    selected = state.prefs.language == lang,
                                    onClick = { onSetLanguage(lang) },
                                    label = { Text(lang.displayName) },
                                    modifier = Modifier.testTag("settings_lang_${lang.code}")
                                )
                            }
                        }
                    }
                }
            }

            // Accessibility: Reading Theme, High Contrast, Font Scale & TTS Speed
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    border = cardBorder,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(strings.themeTitle, style = MaterialTheme.typography.titleMedium)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            ThemeOptionChip(
                                selected = state.prefs.themeMode == ReadingThemeMode.DAY,
                                icon = Icons.Default.WbSunny,
                                label = strings.themeDay,
                                onClick = { onSetThemeMode(ReadingThemeMode.DAY) },
                                modifier = Modifier.weight(1f).testTag("theme_day")
                            )
                            ThemeOptionChip(
                                selected = state.prefs.themeMode == ReadingThemeMode.NIGHT,
                                icon = Icons.Default.DarkMode,
                                label = strings.themeNight,
                                onClick = { onSetThemeMode(ReadingThemeMode.NIGHT) },
                                modifier = Modifier.weight(1f).testTag("theme_night")
                            )
                            ThemeOptionChip(
                                selected = state.prefs.themeMode == ReadingThemeMode.HIGH_CONTRAST,
                                icon = Icons.Default.Contrast,
                                label = strings.themeHighContrast,
                                onClick = { onSetThemeMode(ReadingThemeMode.HIGH_CONTRAST) },
                                modifier = Modifier.weight(1f).testTag("theme_contrast")
                            )
                        }

                        Column {
                            Text(
                                text = "${strings.fontSizeTitle}: ${(state.prefs.fontScale * 100).toInt()}%",
                                style = MaterialTheme.typography.titleSmall
                            )
                            Slider(
                                value = state.prefs.fontScale,
                                onValueChange = onSetFontScale,
                                valueRange = 0.85f..1.35f,
                                modifier = Modifier.testTag("font_scale_slider")
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(Icons.Default.RecordVoiceOver, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Text(strings.ttsSpeedTitle, style = MaterialTheme.typography.titleSmall)
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                listOf(0.85f to "0.85x", 1.0f to "1.0x", 1.25f to "1.25x").forEach { (spd, label) ->
                                    FilterChip(
                                        selected = kotlin.math.abs(state.prefs.ttsSpeed - spd) < 0.05f,
                                        onClick = { onSetTtsSpeed(spd) },
                                        label = { Text(label) },
                                        modifier = Modifier.testTag("tts_speed_$label")
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Daily Notifications & Calendar Sync
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    border = cardBorder,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Text(strings.notificationsTitle, style = MaterialTheme.typography.titleMedium)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = strings.dailyReminderToggle,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            Switch(
                                checked = state.prefs.reminderEnabled,
                                onCheckedChange = { enabled ->
                                    if (enabled && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                        ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
                                    ) {
                                        notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                    } else {
                                        onSetReminderConfig(enabled, state.prefs.reminderHour, state.prefs.reminderMinute)
                                        ReminderScheduler.scheduleDailyReminder(
                                            context, enabled, state.prefs.reminderHour, state.prefs.reminderMinute, state.prefs.language
                                        )
                                    }
                                },
                                modifier = Modifier.testTag("reminder_switch")
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${strings.reminderTimeLabel}: ${String.format(Locale.US, "%02d:%02d", state.prefs.reminderHour, state.prefs.reminderMinute)}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            OutlinedButton(
                                onClick = { showTimePicker = true },
                                modifier = Modifier.minimumInteractiveComponentSize()
                            ) {
                                Icon(Icons.Default.Schedule, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(String.format(Locale.US, "%02d:%02d", state.prefs.reminderHour, state.prefs.reminderMinute))
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                        ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
                                    ) {
                                        notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                    } else {
                                        DailyReminderReceiver.showDailyStudyNotification(context, state.prefs.language)
                                        onShowBanner(strings.notificationSentMsg)
                                    }
                                },
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .minimumInteractiveComponentSize()
                                    .testTag("test_notification_button")
                            ) {
                                Text(strings.testNotificationBtn)
                            }
                            OutlinedButton(
                                onClick = onSyncCalendar,
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .minimumInteractiveComponentSize()
                                    .testTag("settings_calendar_sync")
                            ) {
                                Icon(Icons.Default.CalendarMonth, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(strings.syncCalendar)
                            }
                        }
                    }
                }
            }

            // Automatic Local Offline Progress Summary (No Login Required)
            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    border = cardBorder,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = strings.localResumeTitle,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        Text(
                            text = strings.localResumeDesc,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "${strings.lessonPrefix} ${state.resumeLessonNumber}/27 • ${state.completedLessonCount}/27 ${strings.completedLabel} • ${state.prefs.xp} ${strings.xpLabel}",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }

    if (showTimePicker) {
        val pickerState = rememberTimePickerState(
            initialHour = state.prefs.reminderHour,
            initialMinute = state.prefs.reminderMinute,
            is24Hour = true
        )
        AlertDialog(
            onDismissRequest = { showTimePicker = false },
            title = { Text(strings.reminderTimeLabel) },
            text = { TimePicker(state = pickerState) },
            confirmButton = {
                Button(onClick = {
                    onSetReminderConfig(state.prefs.reminderEnabled, pickerState.hour, pickerState.minute)
                    ReminderScheduler.scheduleDailyReminder(
                        context,
                        state.prefs.reminderEnabled,
                        pickerState.hour,
                        pickerState.minute,
                        state.prefs.language
                    )
                    showTimePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTimePicker = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
private fun ThemeOptionChip(
    selected: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        leadingIcon = {
            Icon(icon, contentDescription = null, modifier = Modifier.size(16.dp))
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 2
            )
        },
        modifier = modifier.minimumInteractiveComponentSize()
    )
}
