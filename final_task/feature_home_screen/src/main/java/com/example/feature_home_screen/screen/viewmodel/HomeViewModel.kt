package com.example.feature_home_screen.screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.common.domain.model.authenticated.ResultMark
import com.example.common.domain.usecase.authenticated.GetAllCoursesUseCase
import com.example.common.domain.usecase.authenticated.GetLastCommunityNoteUseCase
import com.example.feature_home_screen.screen.model.HomeAction
import com.example.feature_home_screen.screen.model.HomeSideEffect
import com.example.feature_home_screen.screen.model.HomeSideNavigate
import com.example.feature_home_screen.screen.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCourses: GetAllCoursesUseCase,
    private val getLastCommunityNote: GetLastCommunityNoteUseCase
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(
        HomeState(
            lastLocalNote = LocalNotePreview(
                id = "test",
                title = "Эта заметка пока не берется с БД",
                date = "28 августа",
                description = "Чтобы просто увидеть как выглядит"
            )
        )
    )

    init {
        getInfo()
    }

    private val _sideNavigate = MutableSharedFlow<HomeSideNavigate>()
    val sideNavigate = _sideNavigate.asSharedFlow()

    private fun getInfo() = intent {
        reduce {
            state.copy(isLoading = true)
        }
        delay(300)
        val respCourses = getAllCourses.execute()
        reduce {
            state.copy(courses = respCourses)
        }
        val respNote = getLastCommunityNote.execute()
        if (respNote.resultMark == ResultMark.Success) {
            reduce {
                state.copy(lastCommunityNote = respNote)
            }
        }
        else if (respNote.resultMark == ResultMark.TokenIsNotValid){
            _sideNavigate.emit(HomeSideNavigate.NavigateToAuthorize)
        }
        reduce {
            state.copy(isLoading = false)
        }
    }

    fun onAction(action: HomeAction) = intent {
        when (action) {
            is HomeAction.OpenSearch -> {}
            is HomeAction.CloseSearch -> {}
            is HomeAction.SearchTextChange -> {}

            is HomeAction.AllCoursesClick -> {
                _sideNavigate.emit(HomeSideNavigate.NavigateToAllCourses)
            }

            is HomeAction.AllLocalNotesClick -> {
                _sideNavigate.emit(HomeSideNavigate.NavigateToAllLocalNotes)
            }

            is HomeAction.AllCommunityNotesClick -> {
                _sideNavigate.emit(HomeSideNavigate.NavigateToAllCommunityNotes)
            }

            is HomeAction.CourseClick -> {}
            is HomeAction.LocalNoteClick -> {}
            is HomeAction.CommunityNoteClick -> {}

            is HomeAction.GetInfo -> {
                getInfo()
            }
        }
    }

}