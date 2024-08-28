package com.example.feature_main_screen

import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.Course
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.ui.model.CourseInfo
import com.example.ui.model.NoteCommonInfo
import com.example.ui.model.NoteCommunityInfo

fun mapToCourseInfo(course: Course): CourseInfo {
    return CourseInfo(title = course.title, tags = course.tags ?: listOf())
}

fun mapToCommunityNoteInfo(communityNotePreview: CommunityNotePreview): NoteCommunityInfo {
    return NoteCommunityInfo(
        noteCommonInfo = NoteCommonInfo(
            title = communityNotePreview.title,
            description = communityNotePreview.description,
            date = communityNotePreview.date
        ),
        lastCommentatorFullName = "${communityNotePreview.author.name} ${communityNotePreview.author.surname}",
        lastCommentatorIconUrl = communityNotePreview.author.avatarUrl
    )
}

fun mapToLocalNoteInfo(localNotePreview: LocalNotePreview): NoteCommonInfo {
    return NoteCommonInfo(
        title = localNotePreview.title,
        description = localNotePreview.description,
        date = localNotePreview.date
    )
}