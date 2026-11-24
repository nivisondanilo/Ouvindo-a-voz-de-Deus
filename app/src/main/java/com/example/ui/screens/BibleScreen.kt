package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.content.OfflineBibleRepository
import com.example.data.local.LocalBibleNote
import com.example.i18n.AppStrings
import com.example.model.BibleVerse
import com.example.model.HighlightColor
import com.example.ui.StudyDashboardState
import com.example.ui.theme.HighlightCoral
import com.example.ui.theme.HighlightEmerald
import com.example.ui.theme.HighlightGold
import com.example.ui.theme.HighlightSky
import com.example.ui.theme.LocalIsHighContrast
import com.example.ui.theme.MerriweatherFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BibleScreen(
    state: StudyDashboardState,
    strings: AppStrings,
    initialBookId: String,
    initialChapter: Int,
    activeSpeechId: String?,
    onToggleSpeech: (String, String) -> Unit,
    onSaveNote: (String, Int, Int, String, String) -> Unit,
    onDeleteNote: (String) -> Unit
) {
    val lang = state.prefs.language
    val isHighContrast = LocalIsHighContrast.current
    val cardBorder = if (isHighContrast) BorderStroke(2.dp, MaterialTheme.colorScheme.outline) else null

    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    var selectedBookId by rememberSaveable { mutableStateOf(initialBookId) }
    var selectedChapterNum by rememberSaveable { mutableIntStateOf(initialChapter) }
    var searchQuery by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(initialBookId, initialChapter) {
        selectedBookId = initialBookId
        selectedChapterNum = initialChapter
        selectedTab = 0
    }

    val currentBook = remember(selectedBookId) { OfflineBibleRepository.getBook(selectedBookId) }
    val currentChapter = remember(currentBook, selectedChapterNum) {
        currentBook.chapters.firstOrNull { it.chapterNumber == selectedChapterNum }
            ?: currentBook.chapters.first()
    }

    val notesByKey = remember(state.notes) {
        state.notes.associateBy { "${it.bookId}_${it.chapter}_${it.verse}" }
    }

    var editingVerse by remember { mutableStateOf<BibleVerse?>(null) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 840.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_bible_night),
                    contentDescription = strings.bibleTitle,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Black.copy(alpha = 0.2f), Color.Black.copy(alpha = 0.75f))
                            )
                        )
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = strings.bibleTitle,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    val chapterSpeechId = "bible_${currentBook.id}_${currentChapter.chapterNumber}"
                    val chapterText = remember(currentBook, currentChapter, lang) {
                        val bookLabel = OfflineBibleRepository.bookName(currentBook, lang)
                        "$bookLabel ${currentChapter.chapterNumber}. " +
                            currentChapter.verses.joinToString(" ") { "${it.verse}: ${it.text}" }
                    }
                    FilledTtsChip(
                        isSpeaking = activeSpeechId == chapterSpeechId,
                        label = if (activeSpeechId == chapterSpeechId) strings.stopVoice else strings.listenVoice,
                        onClick = { onToggleSpeech(chapterSpeechId, chapterText) },
                        tag = "bible_tts_button"
                    )
                }
            }

            PrimaryTabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text(strings.readTab) },
                    modifier = Modifier.testTag("bible_tab_read")
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("${strings.myNotesTab} (${state.notes.size})") },
                    modifier = Modifier.testTag("bible_tab_notes")
                )
            }

            if (selectedTab == 0) {
                val searchResults = remember(searchQuery, lang) {
                    OfflineBibleRepository.searchVerses(searchQuery, lang)
                }

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    item {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text(strings.searchBibleHint) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                            singleLine = true,
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("bible_search_input")
                        )
                    }

                    if (searchQuery.isNotBlank()) {
                        items(searchResults) { (refLabel, verse) ->
                            Card(
                                shape = RoundedCornerShape(18.dp),
                                border = cardBorder,
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedBookId = verse.bookId
                                        selectedChapterNum = verse.chapter
                                        searchQuery = ""
                                    }
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Text(
                                        text = refLabel,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = verse.text,
                                        fontFamily = MerriweatherFontFamily,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    } else {
                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(OfflineBibleRepository.books, key = { it.id }) { book ->
                                    FilterChip(
                                        selected = book.id == currentBook.id,
                                        onClick = {
                                            selectedBookId = book.id
                                            selectedChapterNum = book.chapters.first().chapterNumber
                                        },
                                        label = { Text(OfflineBibleRepository.bookName(book, lang)) },
                                        modifier = Modifier.testTag("book_chip_${book.id}")
                                    )
                                }
                            }
                        }

                        item {
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(currentBook.chapters, key = { it.chapterNumber }) { ch ->
                                    FilterChip(
                                        selected = ch.chapterNumber == currentChapter.chapterNumber,
                                        onClick = { selectedChapterNum = ch.chapterNumber },
                                        label = { Text("${OfflineBibleRepository.bookName(currentBook, lang)} ${ch.chapterNumber}") },
                                        modifier = Modifier.testTag("chapter_chip_${ch.chapterNumber}")
                                    )
                                }
                            }
                        }

                        item {
                            Text(
                                text = "${OfflineBibleRepository.bookName(currentBook, lang)} ${currentChapter.chapterNumber} — ${currentChapter.title}",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        items(currentChapter.verses, key = { "${it.bookId}_${it.chapter}_${it.verse}" }) { verse ->
                            val noteKey = "${verse.bookId}_${verse.chapter}_${verse.verse}"
                            val existingNote = notesByKey[noteKey]
                            val highlightBg = highlightBgColor(existingNote?.highlightColor, isHighContrast)

                            Card(
                                shape = RoundedCornerShape(18.dp),
                                border = cardBorder,
                                colors = CardDefaults.cardColors(
                                    containerColor = highlightBg ?: MaterialTheme.colorScheme.surface
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { editingVerse = verse }
                                    .testTag("verse_card_$noteKey")
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.Top,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Surface(
                                            shape = CircleShape,
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            modifier = Modifier.size(30.dp)
                                        ) {
                                            Box(contentAlignment = Alignment.Center) {
                                                Text(
                                                    text = "${verse.verse}",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                            }
                                        }
                                        Text(
                                            text = verse.text,
                                            fontFamily = MerriweatherFontFamily,
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = if (highlightBg != null && !isHighContrast) {
                                                Color(0xFF0F172A)
                                            } else {
                                                MaterialTheme.colorScheme.onSurface
                                            },
                                            modifier = Modifier.weight(1f)
                                        )
                                        Icon(
                                            imageVector = Icons.Default.EditNote,
                                            contentDescription = strings.addNoteTitle,
                                            tint = if (highlightBg != null && !isHighContrast) {
                                                Color(0xFF1E293B)
                                            } else {
                                                MaterialTheme.colorScheme.primary
                                            }
                                        )
                                    }

                                    existingNote?.let { note ->
                                        Surface(
                                            shape = RoundedCornerShape(12.dp),
                                            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f),
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(10.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.Bookmark,
                                                    contentDescription = null,
                                                    tint = MaterialTheme.colorScheme.primary,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                                Text(
                                                    text = note.noteText,
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (state.notes.isEmpty()) {
                        item {
                            Card(
                                shape = RoundedCornerShape(20.dp),
                                border = cardBorder,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.EditNote,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(44.dp)
                                    )
                                    Text(
                                        text = strings.emptyNotesHint,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    } else {
                        items(state.notes, key = { it.noteId }) { note ->
                            NoteCardItem(
                                note = note,
                                strings = strings,
                                cardBorder = cardBorder,
                                onJumpToVerse = {
                                    selectedBookId = note.bookId
                                    selectedChapterNum = note.chapter
                                    selectedTab = 0
                                },
                                onDelete = { onDeleteNote(note.noteId) }
                            )
                        }
                    }
                }
            }
        }
    }

    editingVerse?.let { verse ->
        val noteKey = "${verse.bookId}_${verse.chapter}_${verse.verse}"
        val existing = notesByKey[noteKey]
        VerseNoteDialog(
            verse = verse,
            bookLabel = OfflineBibleRepository.bookName(OfflineBibleRepository.getBook(verse.bookId), lang),
            existingNote = existing,
            strings = strings,
            onDismiss = { editingVerse = null },
            onSave = { text, colorKey ->
                onSaveNote(verse.bookId, verse.chapter, verse.verse, text, colorKey)
                editingVerse = null
            },
            onDelete = {
                existing?.let { onDeleteNote(it.noteId) }
                editingVerse = null
            }
        )
    }
}

@Composable
private fun NoteCardItem(
    note: LocalBibleNote,
    strings: AppStrings,
    cardBorder: BorderStroke?,
    onJumpToVerse: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        border = cardBorder,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onJumpToVerse)
            .testTag("saved_note_${note.noteId}")
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = note.referenceLabel,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = note.noteText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(
                onClick = onDelete,
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .testTag("delete_note_${note.noteId}")
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = strings.deleteNote,
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun VerseNoteDialog(
    verse: BibleVerse,
    bookLabel: String,
    existingNote: LocalBibleNote?,
    strings: AppStrings,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit,
    onDelete: () -> Unit
) {
    var noteText by remember(verse) { mutableStateOf(existingNote?.noteText ?: "") }
    var selectedColor by remember(verse) { mutableStateOf(existingNote?.highlightColor ?: HighlightColor.GOLD.key) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "${strings.addNoteTitle} • $bookLabel ${verse.chapter}:${verse.verse}",
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "\"${verse.text}\"",
                    fontFamily = MerriweatherFontFamily,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = strings.highlightLabel,
                    style = MaterialTheme.typography.labelLarge
                )
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(HighlightColor.entries) { colorOpt ->
                        FilterChip(
                            selected = selectedColor == colorOpt.key,
                            onClick = { selectedColor = colorOpt.key },
                            label = { Text(colorOpt.labelPt) }
                        )
                    }
                }
                OutlinedTextField(
                    value = noteText,
                    onValueChange = { noteText = it },
                    placeholder = { Text(strings.notePlaceholder) },
                    minLines = 3,
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("verse_note_input")
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onSave(noteText, selectedColor) },
                modifier = Modifier.testTag("save_verse_note_button")
            ) {
                Text(strings.saveNote)
            }
        },
        dismissButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (existingNote != null) {
                    TextButton(onClick = onDelete) {
                        Text(strings.deleteNote, color = MaterialTheme.colorScheme.error)
                    }
                }
                TextButton(onClick = onDismiss) {
                    Text("Fechar")
                }
            }
        }
    )
}

private fun highlightBgColor(colorKey: String?, isHighContrast: Boolean): Color? {
    if (isHighContrast) return null
    return when (colorKey) {
        HighlightColor.GOLD.key -> HighlightGold
        HighlightColor.SKY.key -> HighlightSky
        HighlightColor.EMERALD.key -> HighlightEmerald
        HighlightColor.CORAL.key -> HighlightCoral
        else -> null
    }
}
