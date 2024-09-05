package com.example.feature_home_screen.screen.model

sealed class HomeAction {
    data object OpenSearch : HomeAction()
    data object CloseSearch : HomeAction()
    data class SearchTextChange(val newValue: String) : HomeAction()

    data object AllCoursesClick : HomeAction()
    data object AllLocalNotesClick : HomeAction()
    data object AllCommunityNotesClick : HomeAction()

    data object CourseClick : HomeAction()
    data object LocalNoteClick : HomeAction()
    data class CommunityNoteClick(val id: String) : HomeAction()

    data object GetInfo : HomeAction()
}
