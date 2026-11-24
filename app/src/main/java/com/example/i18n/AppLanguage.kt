package com.example.i18n

enum class AppLanguage(
    val code: String,
    val displayName: String,
    val localeTag: String
) {
    PT("pt", "Português", "pt-BR"),
    EN("en", "English", "en-US"),
    ES("es", "Español", "es-ES");

    companion object {
        fun fromCode(code: String?): AppLanguage =
            entries.firstOrNull { it.code.equals(code, ignoreCase = true) } ?: PT
    }
}
