package com.example.feature_main_screen.screen.model

import com.example.common.domain.model.authenticated.Course

data class MainState(
    val isLoading: Boolean = true,
    val isFailedLoad: Boolean = false,
    val courses: List<Course> = emptyList(),
)
