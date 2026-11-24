package com.example.model

data class BibleVerse(
    val bookId: String,
    val chapter: Int,
    val verse: Int,
    val text: String
)

data class BibleChapter(
    val chapterNumber: Int,
    val title: String,
    val verses: List<BibleVerse>
)

data class BibleBook(
    val id: String,
    val namePt: String,
    val nameEn: String,
    val nameEs: String,
    val testament: String,
    val chapters: List<BibleChapter>
)

enum class HighlightColor(val key: String, val labelPt: String, val labelEn: String, val labelEs: String) {
    NONE("none", "Sem cor", "None", "Sin color"),
    GOLD("gold", "Ouro", "Gold", "Oro"),
    SKY("sky", "Céu", "Sky", "Cielo"),
    EMERALD("emerald", "Esperança", "Hope", "Esperanza"),
    CORAL("coral", "Amor", "Love", "Amor");

    companion object {
        fun fromKey(key: String?): HighlightColor =
            entries.firstOrNull { it.key == key } ?: NONE
    }
}
