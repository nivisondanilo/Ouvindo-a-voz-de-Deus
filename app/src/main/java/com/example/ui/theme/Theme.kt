package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

val AppShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

val LocalIsHighContrast = staticCompositionLocalOf { false }
val LocalReadingFontScale = staticCompositionLocalOf { 1.0f }

@Composable
fun VozDeDeusTheme(
    readingThemeMode: ReadingThemeMode = ReadingThemeMode.DAY,
    fontScale: Float = 1.0f,
    content: @Composable () -> Unit
) {
    val colorScheme = when (readingThemeMode) {
        ReadingThemeMode.DAY -> DayColorScheme
        ReadingThemeMode.NIGHT -> NightColorScheme
        ReadingThemeMode.HIGH_CONTRAST -> HighContrastColorScheme
    }
    val isDark = readingThemeMode != ReadingThemeMode.DAY
    val isHighContrast = readingThemeMode == ReadingThemeMode.HIGH_CONTRAST

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDark
                WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !isDark
            }
        }
    }

    CompositionLocalProvider(
        LocalIsHighContrast provides isHighContrast,
        LocalReadingFontScale provides fontScale
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = buildAppTypography(fontScale),
            shapes = AppShapes,
            content = content
        )
    }
}
