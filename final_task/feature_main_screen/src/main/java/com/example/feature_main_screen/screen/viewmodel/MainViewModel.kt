package com.example.feature_main_screen.screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.common.domain.usecase.authenticated.GetAllCoursesUseCase
import com.example.common.domain.usecase.authenticated.GetLastCommunityNoteUseCase
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
    private val getAllCourses: GetAllCoursesUseCase,
    private val getLastCommunityNote: GetLastCommunityNoteUseCase
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {

    override val container = container<MainState, MainSideEffect>(
        MainState(
            lastLocalNote = LocalNotePreview(
                id = "test",
                title = "Эта заметка пока не берется с БД",
                date = "28 августа",
                description = "Чтобы просто увидеть как выглядит"
            )
        )
    )

    private val _sideNavigate = MutableSharedFlow<MainSideNavigate>()
    val sideNavigate = _sideNavigate.asSharedFlow()

    init {
        init()
    }

    private fun init() = intent {
        val respCourses = getAllCourses.execute()
        reduce {
            state.copy(courses = respCourses)
        }
        val respNote = getLastCommunityNote.execute()
        if (respNote.author.id.isNotEmpty()) {
            reduce {
                state.copy(lastCommunityNote = respNote)
            }
        }
        reduce {
            state.copy(isLoading = false)
        }
    }

    fun onAction(action: MainAction) = intent {
        when (action) {
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