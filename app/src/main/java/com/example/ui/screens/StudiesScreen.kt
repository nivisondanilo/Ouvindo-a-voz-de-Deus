package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.content.StudyCatalog
import com.example.i18n.AppStrings
import com.example.model.StudyCategory
import com.example.model.StudyLesson
import com.example.ui.StudyDashboardState
import com.example.ui.theme.LocalIsHighContrast

@Composable
fun StudiesScreen(
    state: StudyDashboardState,
    strings: AppStrings,
    activeSpeechId: String?,
    onToggleSpeech: (String, String) -> Unit,
    onOpenLessonPhone: (Int) -> Unit,
    onOpenInBible: (String, Int) -> Unit,
    onAnswerThought: (Int, Int, Int) -> Unit,
    onMarkReadingCompleted: (Int) -> Unit,
    onOpenDrawer: () -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }
    var selectedCategory by rememberSaveable { mutableStateOf<StudyCategory?>(null) }
    var tabletSelectedLesson by rememberSaveable { mutableIntStateOf(state.resumeLessonNumber) }

    val filteredLessons = remember(query, selectedCategory) {
        StudyCatalog.allLessons.filter { lesson ->
            val matchesCat = selectedCategory == null || lesson.category == selectedCategory
            val matchesQuery = query.isBlank() ||
                lesson.title.contains(query, ignoreCase = true) ||
                lesson.subtitle.contains(query, ignoreCase = true) ||
                lesson.number.toString() == query.trim()
            matchesCat && matchesQuery
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isExpandedTablet = maxWidth >= 760.dp

        if (isExpandedTablet) {
            Row(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .weight(0.42f)
                        .fillMaxHeight()
                ) {
                    LessonCatalogList(
                        lessons = filteredLessons,
                        state = state,
                        strings = strings,
                        query = query,
                        onQueryChange = { query = it },
                        selectedCategory = selectedCategory,
                        onSelectCategory = { selectedCategory = it },
                        highlightedLessonNumber = tabletSelectedLesson,
                        onOpenDrawer = onOpenDrawer,
                        onLessonClick = { tabletSelectedLesson = it }
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(0.58f)
                        .fillMaxHeight()
                ) {
                    LessonDetailContent(
                        lessonNumber = tabletSelectedLesson,
                        state = state,
                        strings = strings,
                        activeSpeechId = activeSpeechId,
                        onToggleSpeech = onToggleSpeech,
                        onOpenInBible = onOpenInBible,
                        onAnswerThought = onAnswerThought,
                        onMarkReadingCompleted = onMarkReadingCompleted,
                        onSelectLesson = { tabletSelectedLesson = it },
                        onOpenDrawer = onOpenDrawer,
                        showBackButton = false,
                        onBack = {}
                    )
                }
            }
        } else {
            LessonCatalogList(
                lessons = filteredLessons,
                state = state,
                strings = strings,
                query = query,
                onQueryChange = { query = it },
                selectedCategory = selectedCategory,
                onSelectCategory = { selectedCategory = it },
                highlightedLessonNumber = state.resumeLessonNumber,
                onOpenDrawer = onOpenDrawer,
                onLessonClick = onOpenLessonPhone
            )
        }
    }
}

@Composable
private fun LessonCatalogList(
    lessons: List<StudyLesson>,
    state: StudyDashboardState,
    strings: AppStrings,
    query: String,
    onQueryChange: (String) -> Unit,
    selectedCategory: StudyCategory?,
    onSelectCategory: (StudyCategory?) -> Unit,
    highlightedLessonNumber: Int?,
    onOpenDrawer: () -> Unit,
    onLessonClick: (Int) -> Unit
) {
    val lang = state.prefs.language
    val isHighContrast = LocalIsHighContrast.current

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    onClick = onOpenDrawer,
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("studies_sandwich_menu")
                ) {
                    Icon(Icons.Default.Menu, contentDescription = strings.openMenuStudies)
                }
                Text(
                    text = "${strings.appTitle} • 27 ${strings.navStudies}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = { Text(strings.searchLessonsHint) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("studies_search_input")
            )

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    FilterChip(
                        selected = selectedCategory == null,
                        onClick = { onSelectCategory(null) },
                        label = { Text(strings.allCategories) },
                        modifier = Modifier.testTag("cat_all")
                    )
                }
                items(StudyCategory.entries) { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { onSelectCategory(category) },
                        label = { Text(category.label(lang)) },
                        modifier = Modifier.testTag("cat_${category.name.lowercase()}")
                    )
                }
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(lessons, key = { it.number }) { lesson ->
                val progress = state.lessonProgressMap[lesson.number]
                val isDone = progress?.completed == true
                val isSelected = highlightedLessonNumber == lesson.number

                Card(
                    shape = RoundedCornerShape(20.dp),
                    border = when {
                        isSelected -> BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                        isHighContrast -> BorderStroke(2.dp, MaterialTheme.colorScheme.outline)
                        else -> null
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) {
                            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f)
                        } else {
                            MaterialTheme.colorScheme.surface
                        }
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onLessonClick(lesson.number) }
                        .testTag("lesson_card_${lesson.number}")
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = if (isDone) {
                                MaterialTheme.colorScheme.tertiary
                            } else {
                                MaterialTheme.colorScheme.primaryContainer
                            },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                if (isDone) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = strings.completedLabel,
                                        tint = MaterialTheme.colorScheme.onTertiary
                                    )
                                } else {
                                    Text(
                                        text = "${lesson.number}",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "${strings.lessonPrefix} ${lesson.number} • ${lesson.category.label(lang)}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = lesson.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = lesson.subtitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Timer,
                                        contentDescription = null,
                                        modifier = Modifier.size(14.dp),
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "${lesson.estimatedMinutes} ${strings.minutesUnit}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                Text(
                                    text = "+${lesson.xpReward} ${strings.xpLabel}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                                if (progress != null && progress.quizTotal > 0) {
                                    Text(
                                        text = "${progress.quizScore}/${progress.quizTotal}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.tertiary
                                    )
                                }
                            }
                        }

                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
