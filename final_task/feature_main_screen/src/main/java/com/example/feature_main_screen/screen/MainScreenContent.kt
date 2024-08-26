package com.example.feature_main_screen.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.domain.model.authenticated.Course
import com.example.feature_main_screen.mapToCourseInfo
import com.example.feature_main_screen.screen.model.MainAction
import com.example.feature_main_screen.screen.model.MainSideEffect
import com.example.feature_main_screen.screen.model.MainState
import com.example.ui.components.CustomCoursePager
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

    Column {
        CustomCoursePager(
            coursesInfo = state.courses.map { mapToCourseInfo(it) },
            modifier = Modifier
        )
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
            )
        ),
        sideEffects = fakeSideEffects,
        onAction = fakeOnAction
    )
}