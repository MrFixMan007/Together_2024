package com.example.feature_main_screen.screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.common.domain.usecase.authenticated.GetCourseByIdUseCase
import com.example.feature_main_screen.screen.model.MainAction
import com.example.feature_main_screen.screen.model.MainSideEffect
import com.example.feature_main_screen.screen.model.MainSideNavigate
import com.example.feature_main_screen.screen.model.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCourseByIdUseCase: GetCourseByIdUseCase,
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(
        MainState()
    )

    private val _sideNavigate = MutableSharedFlow<MainSideNavigate>()
    val sideNavigate = _sideNavigate.asSharedFlow()

    init {
        init()
    }

    private fun init() = intent {
        val resp = getCourseByIdUseCase.execute("66c641bde9493f1f460dfd69")
        Log.e("response", "$resp")
        reduce {
            state.copy(courses = listOf(resp))
        }
    }

    fun onAction(action: MainAction) = intent {
        when(action){
            is MainAction.OpenSearch -> {}
            is MainAction.CloseSearch -> {}
            is MainAction.SearchTextChange -> {}

            is MainAction.AllCoursesClick -> {
                _sideNavigate.emit(MainSideNavigate.NavigateToAllCourses)
            }
            is MainAction.AllLocalNotesClick -> {
                _sideNavigate.emit(MainSideNavigate.NavigateToAllLocalNotes)
            }
            is MainAction.AllCommunityNotesClick -> {
                _sideNavigate.emit(MainSideNavigate.NavigateToAllCommunityNotes)
            }

            is MainAction.CourseClick -> {}
            is MainAction.LocalNoteClick -> {}
            is MainAction.CommunityNoteClick -> {}
        }
    }

}