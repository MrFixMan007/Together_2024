package com.example.feature_main_screen.screen.model

sealed class MainAction {
    data object OpenSearch : MainAction()
    data object CloseSearch : MainAction()
    data class SearchTextChange(val newValue: String) : MainAction()

    data object AllCoursesClick : MainAction()
    data object AllLocalNotesClick : MainAction()
    data object AllCommunityNotesClick : MainAction()

    data object CourseClick : MainAction()
    data object LocalNoteClick : MainAction()
    data object CommunityNoteClick : MainAction()
}
