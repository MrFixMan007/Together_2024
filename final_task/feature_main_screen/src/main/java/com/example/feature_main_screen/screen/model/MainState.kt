package com.example.feature_main_screen.screen.model

import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.Course
import com.example.common.domain.model.authenticated.LocalNotePreview

data class MainState(
    val isLoading: Boolean = true,
    val isFailedLoad: Boolean = false,
    val courses: List<Course> = emptyList(),
    val lastLocalNote: LocalNotePreview? = null,
    val lastCommunityNote: CommunityNotePreview? = null
)
