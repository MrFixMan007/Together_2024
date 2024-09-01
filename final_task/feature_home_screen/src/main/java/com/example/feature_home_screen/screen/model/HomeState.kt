package com.example.feature_home_screen.screen.model

import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult
import com.example.common.domain.model.authenticated.LocalNotePreview

data class HomeState(
    val isLoading: Boolean = true,
    val isFailedLoad: Boolean = false,
    val courses: List<CoursesPreviewResult> = emptyList(),
    val lastLocalNote: LocalNotePreview? = null,
    val lastCommunityNote: CommunityNotePreviewResult? = null
)
