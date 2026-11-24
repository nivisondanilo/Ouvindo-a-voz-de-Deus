package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.accessibility.TtsManager
import com.example.calendar.CalendarSyncHelper
import com.example.data.content.StudyCatalog
import com.example.data.local.AppDatabase
import com.example.data.local.UserPreferencesRepository
import com.example.data.local.UserPreferencesState
import com.example.i18n.stringsFor
import com.example.notifications.ReminderScheduler
import com.example.ui.MainViewModel
import com.example.ui.screens.BibleScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonDetailContent
import com.example.ui.screens.ProfileSettingsScreen
import com.example.ui.screens.StatsScreen
import com.example.ui.screens.StudiesScreen
import com.example.ui.theme.ReadingThemeMode
import com.example.ui.theme.VozDeDeusTheme
import kotlinx.coroutines.launch

private const val ROUTE_HOME = "home"
private const val ROUTE_STUDIES = "studies"
private const val ROUTE_BIBLE = "bible"
private const val ROUTE_STATS = "stats"
private const val ROUTE_PROFILE = "profile"
private const val ROUTE_LESSON_DETAIL = "lesson_detail/{lessonNumber}"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ReminderScheduler.rescheduleFromPrefs(applicationContext)
        setContent {
            AppRoot()
        }
    }
}

@Composable
fun AppRoot() {
    val context = LocalContext.current
    val prefsRepo = remember(context) { UserPreferencesRepository(context.applicationContext) }
    val prefsState by prefsRepo.preferencesFlow.collectAsStateWithLifecycle(initialValue = UserPreferencesState())
    val initialResume by produceState<Pair<String, Int>?>(initialValue = null, prefsRepo) {
        value = prefsRepo.getInitialResumeState()
    }

    val ttsManager = remember(context) { TtsManager(context.applicationContext) }
    DisposableEffect(ttsManager) {
        onDispose { ttsManager.shutdown() }
    }

    val vm: MainViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                val app = checkNotNull(this[APPLICATION_KEY])
                val db = AppDatabase.getInstance(app)
                MainViewModel(
                    studyDao = db.studyDao(),
                    prefsRepo = UserPreferencesRepository(app)
                )
            }
        }
    )

    VozDeDeusTheme(
        readingThemeMode = prefsState.themeMode,
        fontScale = prefsState.fontScale
    ) {
        val resumeState = initialResume
        if (resumeState != null) {
            MainAppShell(
                viewModel = vm,
                ttsManager = ttsManager,
                initialRoute = resumeState.first,
                initialLessonNumber = resumeState.second
            )
        } else {
            Surface(modifier = Modifier.fillMaxSize()) {}
        }
    }
}

private data class NavTabItem(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val tag: String
)

@Composable
private fun MainAppShell(
    viewModel: MainViewModel,
    ttsManager: TtsManager,
    initialRoute: String,
    initialLessonNumber: Int
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val activeSpeechId by ttsManager.activeSpeechId.collectAsStateWithLifecycle()
    val strings = remember(state.prefs.language) { stringsFor(state.prefs.language) }
    val lang = state.prefs.language

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentLessonArg = navBackStackEntry?.arguments?.getInt("lessonNumber")

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(state.statusBannerMessage) {
        state.statusBannerMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg)
            viewModel.setStatusBanner(null)
        }
    }

    var restoredInitialLesson by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(initialRoute, initialLessonNumber) {
        if (!restoredInitialLesson) {
            restoredInitialLesson = true
            when {
                initialRoute.startsWith("lesson_detail/") -> {
                    val num = initialRoute.removePrefix("lesson_detail/").toIntOrNull() ?: initialLessonNumber
                    navController.navigate("lesson_detail/${num.coerceIn(1, 27)}") {
                        launchSingleTop = true
                    }
                }
                initialRoute in listOf(ROUTE_STUDIES, ROUTE_BIBLE, ROUTE_STATS, ROUTE_PROFILE) -> {
                    navController.navigate(initialRoute) {
                        popUpTo(ROUTE_HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }

    LaunchedEffect(currentRoute, currentLessonArg) {
        when (currentRoute) {
            ROUTE_LESSON_DETAIL -> {
                val num = (currentLessonArg ?: state.resumeLessonNumber).coerceIn(1, 27)
                viewModel.recordLastPosition("lesson_detail/$num", num)
            }
            ROUTE_HOME, ROUTE_STUDIES, ROUTE_BIBLE, ROUTE_STATS, ROUTE_PROFILE -> {
                viewModel.recordLastPosition(currentRoute, null)
            }
        }
    }

    var bibleTargetBook by rememberSaveable { mutableStateOf("gen") }
    var bibleTargetChapter by rememberSaveable { mutableIntStateOf(1) }

    DisposableEffect(Unit) {
        viewModel.startStudyTimer(null)
        onDispose { viewModel.stopStudyTimer() }
    }

    val tabs = remember(strings) {
        listOf(
            NavTabItem(ROUTE_HOME, strings.navHome, Icons.Filled.Home, Icons.Outlined.Home, "nav_home"),
            NavTabItem(ROUTE_STUDIES, strings.navStudies, Icons.Filled.School, Icons.Outlined.School, "nav_studies"),
            NavTabItem(ROUTE_BIBLE, strings.navBible, Icons.Filled.MenuBook, Icons.Outlined.MenuBook, "nav_bible"),
            NavTabItem(ROUTE_STATS, strings.navStats, Icons.Filled.BarChart, Icons.Outlined.BarChart, "nav_stats"),
            NavTabItem(ROUTE_PROFILE, strings.navProfile, Icons.Filled.Settings, Icons.Outlined.Settings, "nav_profile")
        )
    }

    val showChrome = currentRoute != ROUTE_LESSON_DETAIL

    val onSyncCalendarAction = {
        val plan = StudyCatalog.getPlan(state.prefs.selectedPlanId)
        CalendarSyncHelper.launchDailyPlanCalendarEvent(
            context = context,
            plan = plan,
            hour = state.prefs.reminderHour,
            minute = state.prefs.reminderMinute,
            language = state.prefs.language
        )
        viewModel.setStatusBanner(strings.calendarLaunchedMsg)
    }

    val onToggleSpeechAction: (String, String) -> Unit = { speechId, text ->
        ttsManager.toggleSpeak(
            speechId = speechId,
            text = text,
            language = state.prefs.language,
            speechRate = state.prefs.ttsSpeed
        )
    }

    val navigateToLesson: (Int) -> Unit = { num ->
        val safeNum = num.coerceIn(1, 27)
        navController.navigate("lesson_detail/$safeNum") {
            popUpTo(ROUTE_LESSON_DETAIL) { inclusive = true }
            launchSingleTop = true
        }
    }

    val openDrawerAction: () -> Unit = {
        scope.launch { drawerState.open() }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(320.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = strings.drawerStudiesTitle,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = strings.drawerStudiesSubtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                HorizontalDivider()
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(StudyCatalog.allLessons, key = { it.number }) { lesson ->
                        val isDone = state.lessonProgressMap[lesson.number]?.completed == true
                        val isCurrent = (currentRoute == ROUTE_LESSON_DETAIL && currentLessonArg == lesson.number) ||
                            (currentRoute != ROUTE_LESSON_DETAIL && state.resumeLessonNumber == lesson.number)

                        NavigationDrawerItem(
                            selected = isCurrent,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                    navigateToLesson(lesson.number)
                                }
                            },
                            shape = RoundedCornerShape(14.dp),
                            icon = {
                                Surface(
                                    shape = CircleShape,
                                    color = if (isDone) {
                                        MaterialTheme.colorScheme.tertiary
                                    } else if (isCurrent) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        MaterialTheme.colorScheme.surfaceVariant
                                    },
                                    modifier = Modifier.size(30.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        if (isDone) {
                                            Icon(
                                                imageVector = Icons.Default.CheckCircle,
                                                contentDescription = strings.completedLabel,
                                                tint = MaterialTheme.colorScheme.onTertiary,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        } else {
                                            Text(
                                                text = "${lesson.number}",
                                                style = MaterialTheme.typography.labelMedium,
                                                color = if (isCurrent) {
                                                    MaterialTheme.colorScheme.onPrimary
                                                } else {
                                                    MaterialTheme.colorScheme.onSurfaceVariant
                                                }
                                            )
                                        }
                                    }
                                }
                            },
                            label = {
                                Column {
                                    Text(
                                        text = lesson.title,
                                        style = MaterialTheme.typography.bodyMedium,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = lesson.category.label(lang),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1
                                    )
                                }
                            },
                            modifier = Modifier.testTag("drawer_lesson_${lesson.number}")
                        )
                    }
                }
            }
        }
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val useNavRail = maxWidth >= 600.dp

            Scaffold(
                contentWindowInsets = WindowInsets.safeDrawing,
                snackbarHost = { SnackbarHost(snackbarHostState) },
                bottomBar = {
                    if (showChrome && !useNavRail) {
                        NavigationBar {
                            tabs.forEach { tab ->
                                val selected = currentRoute == tab.route
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(tab.route) {
                                            popUpTo(ROUTE_HOME) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                            contentDescription = tab.label
                                        )
                                    },
                                    label = { Text(tab.label, maxLines = 1) },
                                    modifier = Modifier.testTag(tab.tag)
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    if (showChrome && useNavRail) {
                        NavigationRail(modifier = Modifier.fillMaxHeight()) {
                            tabs.forEach { tab ->
                                val selected = currentRoute == tab.route
                                NavigationRailItem(
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(tab.route) {
                                            popUpTo(ROUTE_HOME) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                                            contentDescription = tab.label
                                        )
                                    },
                                    label = { Text(tab.label) },
                                    modifier = Modifier.testTag("${tab.tag}_rail")
                                )
                            }
                        }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = ROUTE_HOME,
                        modifier = Modifier.weight(1f)
                    ) {
                        composable(ROUTE_HOME) {
                            HomeScreen(
                                state = state,
                                strings = strings,
                                activeSpeechId = activeSpeechId,
                                onToggleSpeech = onToggleSpeechAction,
                                onOpenLesson = navigateToLesson,
                                onOpenDrawer = openDrawerAction,
                                onSelectPlan = viewModel::selectReadingPlan,
                                onTogglePlanDay = viewModel::togglePlanDay,
                                onSyncCalendar = onSyncCalendarAction,
                                onCycleTheme = {
                                    val next = when (state.prefs.themeMode) {
                                        ReadingThemeMode.DAY -> ReadingThemeMode.NIGHT
                                        ReadingThemeMode.NIGHT -> ReadingThemeMode.HIGH_CONTRAST
                                        ReadingThemeMode.HIGH_CONTRAST -> ReadingThemeMode.DAY
                                    }
                                    viewModel.setThemeMode(next)
                                }
                            )
                        }

                        composable(ROUTE_STUDIES) {
                            StudiesScreen(
                                state = state,
                                strings = strings,
                                activeSpeechId = activeSpeechId,
                                onToggleSpeech = onToggleSpeechAction,
                                onOpenLessonPhone = navigateToLesson,
                                onOpenInBible = { bookId, ch ->
                                    bibleTargetBook = bookId
                                    bibleTargetChapter = ch
                                    navController.navigate(ROUTE_BIBLE) {
                                        popUpTo(ROUTE_HOME) { saveState = true }
                                        launchSingleTop = true
                                    }
                                },
                                onAnswerThought = viewModel::answerThoughtQuestion,
                                onMarkReadingCompleted = viewModel::markReadingCompleted,
                                onOpenDrawer = openDrawerAction
                            )
                        }

                        composable(
                            route = ROUTE_LESSON_DETAIL,
                            arguments = listOf(navArgument("lessonNumber") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val lessonNumber = backStackEntry.arguments?.getInt("lessonNumber") ?: 1
                            DisposableEffect(lessonNumber) {
                                viewModel.startStudyTimer(lessonNumber)
                                onDispose { viewModel.startStudyTimer(null) }
                            }
                            LessonDetailContent(
                                lessonNumber = lessonNumber,
                                state = state,
                                strings = strings,
                                activeSpeechId = activeSpeechId,
                                onToggleSpeech = onToggleSpeechAction,
                                onOpenInBible = { bookId, ch ->
                                    bibleTargetBook = bookId
                                    bibleTargetChapter = ch
                                    navController.navigate(ROUTE_BIBLE) {
                                        popUpTo(ROUTE_HOME) { saveState = true }
                                        launchSingleTop = true
                                    }
                                },
                                onAnswerThought = viewModel::answerThoughtQuestion,
                                onMarkReadingCompleted = viewModel::markReadingCompleted,
                                onSelectLesson = navigateToLesson,
                                onOpenDrawer = openDrawerAction,
                                showBackButton = true,
                                onBack = {
                                    if (!navController.popBackStack()) {
                                        navController.navigate(ROUTE_HOME) {
                                            launchSingleTop = true
                                        }
                                    }
                                }
                            )
                        }

                        composable(ROUTE_BIBLE) {
                            BibleScreen(
                                state = state,
                                strings = strings,
                                initialBookId = bibleTargetBook,
                                initialChapter = bibleTargetChapter,
                                activeSpeechId = activeSpeechId,
                                onToggleSpeech = onToggleSpeechAction,
                                onSaveNote = viewModel::saveBibleNote,
                                onDeleteNote = viewModel::deleteBibleNote
                            )
                        }

                        composable(ROUTE_STATS) {
                            StatsScreen(
                                state = state,
                                strings = strings
                            )
                        }

                        composable(ROUTE_PROFILE) {
                            ProfileSettingsScreen(
                                state = state,
                                strings = strings,
                                onSetLanguage = viewModel::setLanguage,
                                onSetThemeMode = viewModel::setThemeMode,
                                onSetFontScale = viewModel::setFontScale,
                                onSetTtsSpeed = viewModel::setTtsSpeed,
                                onSetReminderConfig = viewModel::setReminderConfig,
                                onSyncCalendar = onSyncCalendarAction,
                                onShowBanner = viewModel::setStatusBanner
                            )
                        }
                    }
                }
            }
        }
    }
}
