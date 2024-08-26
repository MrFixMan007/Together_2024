package com.example.feature_main_screen.screen.model

sealed class MainSideNavigate {
    data object NavigateToAllCourses : MainSideNavigate()
    data object NavigateToAllLocalNotes : MainSideNavigate()
    data object NavigateToAllCommunityNotes : MainSideNavigate()
}