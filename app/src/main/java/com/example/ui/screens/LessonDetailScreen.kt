package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.R
import com.example.data.content.OfflineBibleRepository
import com.example.data.content.StudyCatalog
import com.example.i18n.AppStrings
import com.example.model.KeyVerseRef
import com.example.model.StudyHeaderArt
import com.example.model.StudyThoughtBlock
import com.example.ui.StudyDashboardState
import com.example.ui.theme.LocalIsHighContrast
import com.example.ui.theme.MerriweatherFontFamily

private const val YOUTUBE_PLAYLIST_BASE =
    "https://www.youtube.com/playlist?list=PL38l87HYfpbnwPGs9Y-x3bA0y5eHjZBgw"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun LessonDetailContent(
    lessonNumber: Int,
    state: StudyDashboardState,
    strings: AppStrings,
    activeSpeechId: String?,
    onToggleSpeech: (String, String) -> Unit,
    onOpenInBible: (String, Int) -> Unit,
    onAnswerThought: (Int, Int, Int) -> Unit,
    onMarkReadingCompleted: (Int) -> Unit,
    onSelectLesson: (Int) -> Unit,
    onOpenDrawer: () -> Unit,
    showBackButton: Boolean,
    onBack: () -> Unit
) {
    if (showBackButton) {
        BackHandler(onBack = onBack)
    }

    val context = LocalContext.current
    val lesson = remember(lessonNumber) { StudyCatalog.getLesson(lessonNumber) }
    val progress = state.lessonProgressMap[lesson.number]
    val lang = state.prefs.language
    val isHighContrast = LocalIsHighContrast.current
    val cardBorder = if (isHighContrast) BorderStroke(2.dp, MaterialTheme.colorScheme.outline) else null

    var activePopupVerse by remember { mutableStateOf<KeyVerseRef?>(null) }

    val answeredInLesson = remember(lesson.number, state.prefs.answeredOptions) {
        lesson.thoughtBlocks.count { tb ->
            state.prefs.answeredOptions.containsKey("${lesson.number}_${tb.stepNumber}")
        }
    }

    val speechId = "lesson_${lesson.number}"
    val fullNarrationText = remember(lesson) {
        buildString {
            append("${lesson.title}. ${lesson.subtitle}. ")
            append("${lesson.blogIntro}. ")
            lesson.thoughtBlocks.forEach { block ->
                append("${block.heading}. ${block.studyText}. ")
            }
            append(lesson.motivationalMessage)
        }
    }

    val headerDrawable = remember(lesson.headerArt) {
        when (lesson.headerArt) {
            StudyHeaderArt.HERO_STUDY -> R.drawable.img_hero_study
            StudyHeaderArt.BIBLE_NIGHT -> R.drawable.img_bible_night
            StudyHeaderArt.PROPHECY -> R.drawable.img_study_prophecy
            StudyHeaderArt.BADGE_TROPHY -> R.drawable.img_badge_trophy
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Column {
                    Text(
                        text = "${strings.lessonPrefix} ${lesson.number}/27",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = lesson.title,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1
                    )
                }
            },
            navigationIcon = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onOpenDrawer,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("sandwich_menu_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = strings.openMenuStudies
                        )
                    }
                    if (showBackButton) {
                        IconButton(
                            onClick = onBack,
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("lesson_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar"
                            )
                        }
                    }
                }
            },
            actions = {
                FilledTtsChip(
                    isSpeaking = activeSpeechId == speechId,
                    label = if (activeSpeechId == speechId) strings.stopVoice else strings.listenVoice,
                    onClick = { onToggleSpeech(speechId, fullNarrationText) },
                    tag = "lesson_tts_button"
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 760.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                // Blog Header Banner Image
                item(key = "header_${lesson.number}") {
                    Card(
                        shape = RoundedCornerShape(24.dp),
                        border = cardBorder,
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                        ) {
                            Image(
                                painter = painterResource(id = headerDrawable),
                                contentDescription = lesson.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                Color.Black.copy(alpha = 0.12f),
                                                Color.Black.copy(alpha = 0.82f)
                                            )
                                        )
                                    )
                            )
                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(50),
                                        color = MaterialTheme.colorScheme.secondary
                                    ) {
                                        Text(
                                            text = "${strings.lessonPrefix} ${lesson.number} • ${lesson.category.label(lang)}",
                                            style = MaterialTheme.typography.labelMedium,
                                            color = MaterialTheme.colorScheme.onSecondary,
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                        )
                                    }
                                    Surface(
                                        shape = RoundedCornerShape(50),
                                        color = Color.White.copy(alpha = 0.2f)
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Timer,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(14.dp)
                                            )
                                            Text(
                                                text = "${lesson.estimatedMinutes} ${strings.minutesUnit}",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                                Text(
                                    text = lesson.title,
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = lesson.subtitle,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White.copy(alpha = 0.92f)
                                )
                            }
                        }
                    }
                }

                // Blog Intro & Verse Popup Instruction
                item(key = "intro_${lesson.number}") {
                    Card(
                        shape = RoundedCornerShape(22.dp),
                        border = cardBorder,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = lesson.blogIntro,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.MenuBook,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Text(
                                        text = strings.tapVersePopupHint,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = MaterialTheme.colorScheme.surface
                                ) {
                                    Text(
                                        text = "$answeredInLesson/${lesson.thoughtBlocks.size} ${strings.answeredCountLabel}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Unified Blog Thought Blocks (Reading + Clickable Verse Chips + Inline Question at end of each block)
                items(
                    items = lesson.thoughtBlocks,
                    key = { "${lesson.number}_${it.stepNumber}" }
                ) { block ->
                    val chosenOption = state.prefs.answeredOptions["${lesson.number}_${block.stepNumber}"]
                    ThoughtBlockBlogCard(
                        lessonNumber = lesson.number,
                        block = block,
                        chosenOption = chosenOption,
                        strings = strings,
                        cardBorder = cardBorder,
                        isHighContrast = isHighContrast,
                        onOpenVersePopup = { ref -> activePopupVerse = ref },
                        onSelectOption = { optIdx ->
                            onAnswerThought(lesson.number, block.stepNumber, optIdx)
                        }
                    )
                }

                // Adventist Takeaway & Mark Completed
                item(key = "conclusion_${lesson.number}") {
                    Card(
                        shape = RoundedCornerShape(22.dp),
                        border = cardBorder,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.65f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoAwesome,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.tertiary
                                )
                                Text(
                                    text = lesson.motivationalMessage,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                            }

                            Button(
                                onClick = { onMarkReadingCompleted(lesson.number) },
                                shape = RoundedCornerShape(16.dp),
                                colors = if (progress?.completed == true) {
                                    ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.tertiary,
                                        contentColor = MaterialTheme.colorScheme.onTertiary
                                    )
                                } else {
                                    ButtonDefaults.buttonColors()
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp)
                                    .testTag("mark_reading_done_button")
                            ) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if (progress?.completed == true) {
                                        strings.lessonCompletedLabel
                                    } else {
                                        strings.markLessonDone
                                    }
                                )
                            }
                        }
                    }
                }

                // Dedicated YouTube Playlist Video Card
                item(key = "youtube_${lesson.number}") {
                    Card(
                        shape = RoundedCornerShape(22.dp),
                        border = cardBorder,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PlayCircleFilled,
                                    contentDescription = null,
                                    tint = Color(0xFFD32F2F),
                                    modifier = Modifier.size(32.dp)
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = strings.youtubeSectionTitle,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                    Text(
                                        text = "Vídeo ${lesson.youtubePlaylistIndex}/27 • ${lesson.youtubeVideoTitle}",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                            Text(
                                text = strings.youtubeSectionSubtitle,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Button(
                                onClick = {
                                    val videoUrl = "$YOUTUBE_PLAYLIST_BASE&index=${lesson.youtubePlaylistIndex}"
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                                    runCatching { context.startActivity(intent) }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFC62828),
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp)
                                    .testTag("youtube_video_button_${lesson.number}")
                            ) {
                                Icon(Icons.Default.PlayCircleFilled, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("${strings.youtubeWatchButton} (${lesson.youtubePlaylistIndex}/27)")
                            }
                        }
                    }
                }

                // Previous / Next Study Footer Navigation
                item(key = "nav_footer_${lesson.number}") {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        if (lesson.number > 1) {
                            OutlinedButton(
                                onClick = { onSelectLesson(lesson.number - 1) },
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(50.dp)
                                    .testTag("prev_lesson_button")
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(strings.previousLessonBtn, maxLines = 1)
                            }
                        }
                        if (lesson.number < 27) {
                            Button(
                                onClick = { onSelectLesson(lesson.number + 1) },
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(50.dp)
                                    .testTag("next_lesson_button")
                            ) {
                                Text(strings.nextLessonBtn, maxLines = 1)
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }
    }

    // Bible Reference Popup Modal (closes on outside tap or 'X' button)
    activePopupVerse?.let { ref ->
        val fullPassage = remember(ref) { OfflineBibleRepository.findPassageText(ref) }
        val verseSpeechId = "popup_verse_${ref.bookId}_${ref.chapter}_${ref.verse}"
        Dialog(
            onDismissRequest = { activePopupVerse = null },
            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            )
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                border = cardBorder,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("bible_verse_popup_dialog")
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primaryContainer,
                                modifier = Modifier.size(36.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.MenuBook,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                            Text(
                                text = ref.reference,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        IconButton(
                            onClick = { activePopupVerse = null },
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("verse_popup_close_x")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = strings.closeLabel,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    HorizontalDivider()

                    Text(
                        text = "\"$fullPassage\"",
                        fontFamily = MerriweatherFontFamily,
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilledTtsChip(
                            isSpeaking = activeSpeechId == verseSpeechId,
                            label = if (activeSpeechId == verseSpeechId) strings.stopVoice else strings.listenVoice,
                            onClick = { onToggleSpeech(verseSpeechId, "${ref.reference}. $fullPassage") },
                            tag = "popup_verse_tts"
                        )
                        OutlinedButton(
                            onClick = {
                                activePopupVerse = null
                                onOpenInBible(ref.bookId, ref.chapter)
                            },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .weight(1f)
                                .minimumInteractiveComponentSize()
                                .testTag("popup_open_in_bible")
                        ) {
                            Text(strings.openInBible, maxLines = 1)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ThoughtBlockBlogCard(
    lessonNumber: Int,
    block: StudyThoughtBlock,
    chosenOption: Int?,
    strings: AppStrings,
    cardBorder: BorderStroke?,
    isHighContrast: Boolean,
    onOpenVersePopup: (KeyVerseRef) -> Unit,
    onSelectOption: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(22.dp),
        border = cardBorder,
        colors = CardDefaults.cardColors(
            containerColor = if (block.isReview) {
                MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(50),
                color = if (block.isReview) {
                    MaterialTheme.colorScheme.secondary
                } else {
                    MaterialTheme.colorScheme.primaryContainer
                }
            ) {
                Text(
                    text = if (block.isReview) strings.reviewLabel else "${strings.thoughtPrefix} ${block.stepNumber}",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (block.isReview) {
                        MaterialTheme.colorScheme.onSecondary
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    },
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }

            Text(
                text = block.heading,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = block.studyText,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Clickable Bible references that open the popup modal
            if (block.bibleRefs.isNotEmpty()) {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    block.bibleRefs.forEach { ref ->
                        Surface(
                            onClick = { onOpenVersePopup(ref) },
                            shape = RoundedCornerShape(50),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.45f)),
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("verse_chip_${lessonNumber}_${block.stepNumber}_${ref.bookId}_${ref.chapter}_${ref.verse}")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MenuBook,
                                    contentDescription = ref.reference,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = ref.reference,
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))

            // Inline Question at the end of this Thought Block
            val q = block.question
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = q.question,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    q.options.forEachIndexed { idx, optionText ->
                        val answered = chosenOption != null
                        val isChosen = chosenOption == idx
                        val isCorrectOption = idx == q.correctIndex

                        val containerColor = when {
                            !answered -> MaterialTheme.colorScheme.surface
                            isCorrectOption -> MaterialTheme.colorScheme.tertiaryContainer
                            isChosen -> MaterialTheme.colorScheme.error.copy(alpha = 0.18f)
                            else -> MaterialTheme.colorScheme.surface.copy(alpha = 0.65f)
                        }

                        val borderColor = when {
                            !answered -> MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
                            isCorrectOption -> MaterialTheme.colorScheme.tertiary
                            isChosen -> MaterialTheme.colorScheme.error
                            else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                        }

                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = containerColor,
                            border = BorderStroke(
                                width = if (isHighContrast || isChosen || (answered && isCorrectOption)) 2.dp else 1.dp,
                                color = borderColor
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = !answered) { onSelectOption(idx) }
                                .minimumInteractiveComponentSize()
                                .testTag("thought_${lessonNumber}_${block.stepNumber}_opt_$idx")
                        ) {
                            Text(
                                text = optionText,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                            )
                        }
                    }

                    if (chosenOption != null) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = q.verseRef,
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = q.explanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
