package com.example.feature_home_screen.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.domain.model.authenticated.Author
import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.ui.R
import com.example.feature_home_screen.mapToCourseInfo
import com.example.feature_home_screen.mapToCommunityNoteInfo
import com.example.feature_home_screen.mapToLocalNoteInfo
import com.example.feature_home_screen.screen.model.HomeAction
import com.example.feature_home_screen.screen.model.HomeSideEffect
import com.example.feature_home_screen.screen.model.HomeState
import com.example.ui.components.CustomCoursePager
import com.example.ui.components.CustomHeader
import com.example.ui.components.IndeterminateCircularIndicator
import com.example.ui.components.custom_cards.CustomCommunityNote
import com.example.ui.components.custom_cards.CustomSimpleNote
import com.example.ui.theme.Yellow
import com.example.ui.time_formating.formatFromDatabaseToLocalDate
import com.example.ui.time_formating.formatUtcToLocalDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreenContent(
    state: HomeState,
    sideEffects: Flow<HomeSideEffect>,
    stack: State<NavBackStackEntry?>,
    onAction: (HomeAction) -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(stack.value?.destination?.route) {
        if (!state.isLoading){
            onAction(HomeAction.GetInfo)
        }
    }

    LaunchedEffect(sideEffects) {
        sideEffects.collect { sideEffect ->
            when (sideEffect) {
                is HomeSideEffect.FailedLoad -> {
                    Toast.makeText(
                        context,
                        "error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                IndeterminateCircularIndicator(
                    modifier = Modifier
                        .size(56.dp)
                        .align(Alignment.Center),
                    loadingState = true,
                    color = Color.White,
                    trackColor = Yellow
                )
            }
        }
        if (state.courses.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            CustomHeader(
                title = context.getString(R.string.yours_courses),
                clickText = context.getString(R.string.all),
                onClick = {})
            Spacer(modifier = Modifier.height(12.dp))
            CustomCoursePager(
                coursesInfo = state.courses.filter { it.title.isNotEmpty() }
                    .map { mapToCourseInfo(it) }
            )
        }

        state.lastLocalNote?.let {
            Spacer(modifier = Modifier.height(24.dp))
            CustomHeader(
                title = context.getString(R.string.yours_notes),
                clickText = context.getString(R.string.all),
                onClick = {})
            Spacer(modifier = Modifier.height(12.dp))
            CustomSimpleNote(
                noteInfo = mapToLocalNoteInfo(
                    state.lastLocalNote.copy(
                        date = formatFromDatabaseToLocalDate(
                            date = state.lastLocalNote.date,
                            context = context
                        )
                    )
                )
            )
        }

        state.lastCommunityNote?.let {
            Spacer(modifier = Modifier.height(20.dp))
            CustomHeader(
                title = context.getString(R.string.community_notes),
                clickText = context.getString(R.string.all),
                onClick = {})
            Spacer(modifier = Modifier.height(12.dp))
            if (state.lastCommunityNote.data != null) {
                val noteInfo = mapToCommunityNoteInfo(state.lastCommunityNote)
                CustomCommunityNote(
                    noteInfo = noteInfo.copy(
                        noteCommonInfo = noteInfo.noteCommonInfo.copy(
                            date = formatUtcToLocalDate(
                                date = noteInfo.noteCommonInfo.date,
                                context = context
                            )
                        )
                    )
                )
            }
        }

    }
}

@Composable
@Preview
private fun Preview() {
    val fakeSideEffects: Flow<HomeSideEffect> = flowOf()
    val fakeOnAction: (HomeAction) -> Unit = {}
    HomeScreenContent(
        state = HomeState(
            isLoading = false,
            courses = listOf(
                CoursesPreviewResult(
                    id = "",
                    title = "Основы Андроида",
                    description = "blum",
                    tags = listOf(
                        "View",
                        "Компоненты Андроид",
                        "Создание проекта",
                        "Intent",
                        "Manifest"
                    )
                ),
                CoursesPreviewResult(
                    id = "",
                    title = "Основы",
                    description = "blum",
                    tags = listOf(
                        "View",
                        "Intent",
                        "Manifest"
                    )
                ),
            ),
            lastCommunityNote = CommunityNotePreviewResult(
                data = CommunityNotePreview(
                    id = "",
                    title = "Каго\nчо?",
                    description = "Что у кого что",
                    author = Author(
                        id = "",
                        name = "Данил",
                        surname = "Гамалкин",
                        avatarUrl = ""
                    ),
                    date = "2024-08-30T19:28:04Z"
                ),
            ),
            lastLocalNote = LocalNotePreview(
                id = "",
                title = "Для создания новой Activity",
                date = "2024-08-30 19:28:04",
                description = "Нужно лишь применить старый дедовский визард"
            )
        ),
        sideEffects = fakeSideEffects,
        onAction = fakeOnAction,
        stack = rememberNavController().currentBackStackEntryAsState()
    )
}