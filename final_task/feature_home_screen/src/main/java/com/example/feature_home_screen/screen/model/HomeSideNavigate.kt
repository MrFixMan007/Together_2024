package com.example.feature_home_screen.screen.model

sealed class HomeSideNavigate {
    data object NavigateToAllCourses : HomeSideNavigate()
    data object NavigateToAllLocalNotes : HomeSideNavigate()
    data object NavigateToAllCommunityNotes : HomeSideNavigate()
    data object NavigateToCommunityNote : HomeSideNavigate()
    data object NavigateToAuthorize : HomeSideNavigate()
}