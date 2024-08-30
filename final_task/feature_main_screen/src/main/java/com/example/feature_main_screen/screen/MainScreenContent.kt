package com.example.feature_main_screen.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.common.domain.model.authenticated.Author
import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.Course
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.ui.R
import com.example.feature_main_screen.mapToCourseInfo
import com.example.feature_main_screen.mapToCommunityNoteInfo
import com.example.feature_main_screen.mapToLocalNoteInfo
import com.example.feature_main_screen.screen.model.MainAction
import com.example.feature_main_screen.screen.model.MainSideEffect
import com.example.feature_main_screen.screen.model.MainState
import com.example.ui.components.CustomCoursePager
import com.example.ui.components.CustomHeader
import com.example.ui.components.custom_cards.CustomCommunityNote
import com.example.ui.components.custom_cards.CustomSimpleNote
import com.example.ui.time_formating.formatUtcToLocalDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun MainScreenContent(
    state: MainState,
    sideEffects: Flow<MainSideEffect>,
    onAction: (MainAction) -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(sideEffects) {
        sideEffects.collect { sideEffect ->
            when (sideEffect) {
                is MainSideEffect.FailedLoad -> {
                    Toast.makeText(
                        context,
                        "error",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> Unit
            }
        }
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
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
                noteInfo = mapToLocalNoteInfo(state.lastLocalNote)
            )
        }

        state.lastCommunityNote?.let {
            Spacer(modifier = Modifier.height(20.dp))
            CustomHeader(
                title = context.getString(R.string.community_notes),
                clickText = context.getString(R.string.all),
                onClick = {})
            Spacer(modifier = Modifier.height(12.dp))
            val noteInfo = mapToCommunityNoteInfo(state.lastCommunityNote)
            CustomCommunityNote(
                noteInfo = noteInfo.copy(noteCommonInfo = noteInfo.noteCommonInfo.copy(date = formatUtcToLocalDate(noteInfo.noteCommonInfo.date, context)))
            )
        }

    }
}

@Composable
@Preview
private fun Preview() {
    val fakeSideEffects: Flow<MainSideEffect> = flowOf()
    val fakeOnAction: (MainAction) -> Unit = {}
    MainScreenContent(
        state = MainState(
            isLoading = false,
            courses = listOf(
                Course(
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
                Course(
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
            lastCommunityNote = CommunityNotePreview(
                id = "",
                title = "Каго\nчо?",
                description = "Что у кого что",
                author = Author(
                    id = "",
                    name = "Данил",
                    surname = "Гамалкин",
                    avatarUrl = "https://nastroyvse.ru/wp-content/uploads/2017/01/drugaya-versiya-android.jpg"
                ),
                date = "2024-08-30T19:28:04Z"
            ),
            lastLocalNote = LocalNotePreview(
                id = "",
                title = "Для создания новой Activity",
                date = "12 июля",
                description = "Нужно лишь применить старый дедовский визард"
            )
        ),
        sideEffects = fakeSideEffects,
        onAction = fakeOnAction
    )
}