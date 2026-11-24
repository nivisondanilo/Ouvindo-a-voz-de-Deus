package com.example.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

enum class ReadingThemeMode(val id: String) {
    DAY("day"),
    NIGHT("night"),
    HIGH_CONTRAST("high_contrast");

    companion object {
        fun fromId(id: String?): ReadingThemeMode =
            entries.firstOrNull { it.id == id } ?: DAY
    }
}

// Brand & Accent Colors
val SapphirePrimary = Color(0xFF155EEF)
val SapphireContainer = Color(0xFFDCE7FF)
val AmberGold = Color(0xFFF59E0B)
val AmberContainer = Color(0xFFFEF3C7)
val EmeraldTeal = Color(0xFF0D9488)
val EmeraldContainer = Color(0xFFCCFBF1)
val CoralAccent = Color(0xFFF43F5E)

// Highlight Palette
val HighlightGold = Color(0xFFFDE68A)
val HighlightSky = Color(0xFFBAE6FD)
val HighlightEmerald = Color(0xFFA7F3D0)
val HighlightCoral = Color(0xFFFECDD3)

val DayColorScheme = lightColorScheme(
    primary = SapphirePrimary,
    onPrimary = Color.White,
    primaryContainer = SapphireContainer,
    onPrimaryContainer = Color(0xFF0B2559),
    secondary = AmberGold,
    onSecondary = Color(0xFF2B1900),
    secondaryContainer = AmberContainer,
    onSecondaryContainer = Color(0xFF452800),
    tertiary = EmeraldTeal,
    onTertiary = Color.White,
    tertiaryContainer = EmeraldContainer,
    onTertiaryContainer = Color(0xFF042F2E),
    background = Color(0xFFF5F8FF),
    onBackground = Color(0xFF0F172A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFE8EEF9),
    onSurfaceVariant = Color(0xFF475569),
    outline = Color(0xFFCBD5E1),
    error = Color(0xFFDC2626),
    onError = Color.White
)

// Comfortable Night Mode for prolonged evening Bible study
val NightColorScheme = darkColorScheme(
    primary = Color(0xFF7AA7FF),
    onPrimary = Color(0xFF08204D),
    primaryContainer = Color(0xFF1B3466),
    onPrimaryContainer = Color(0xFFDCE7FF),
    secondary = Color(0xFFFBBF24),
    onSecondary = Color(0xFF2D1C00),
    secondaryContainer = Color(0xFF473208),
    onSecondaryContainer = Color(0xFFFEF3C7),
    tertiary = Color(0xFF2DD4BF),
    onTertiary = Color(0xFF032D27),
    tertiaryContainer = Color(0xFF0F3D37),
    onTertiaryContainer = Color(0xFFCCFBF1),
    background = Color(0xFF0D131D),
    onBackground = Color(0xFFECE6D8),
    surface = Color(0xFF151E2C),
    onSurface = Color(0xFFECE6D8),
    surfaceVariant = Color(0xFF1F2B3D),
    onSurfaceVariant = Color(0xFFB5C0D0),
    outline = Color(0xFF334155),
    error = Color(0xFFF87171),
    onError = Color(0xFF450A0A)
)

// High Contrast Accessibility Mode (WCAG AAA)
val HighContrastColorScheme = darkColorScheme(
    primary = Color(0xFFFFD600),
    onPrimary = Color(0xFF000000),
    primaryContainer = Color(0xFF262200),
    onPrimaryContainer = Color(0xFFFFEA70),
    secondary = Color(0xFF00E5FF),
    onSecondary = Color(0xFF000000),
    secondaryContainer = Color(0xFF002B33),
    onSecondaryContainer = Color(0xFF99F5FF),
    tertiary = Color(0xFF00FF88),
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFF002E18),
    onTertiaryContainer = Color(0xFFA6FFD5),
    background = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF0A0A0A),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF1A1A1A),
    onSurfaceVariant = Color(0xFFFFFFFF),
    outline = Color(0xFFFFFFFF),
    error = Color(0xFFFF5252),
    onError = Color(0xFF000000)
)
