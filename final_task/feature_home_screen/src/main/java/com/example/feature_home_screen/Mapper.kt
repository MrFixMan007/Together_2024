package com.example.feature_home_screen

import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.ui.model.CourseInfo
import com.example.ui.model.NoteCommonInfo
import com.example.ui.model.NoteCommunityInfo

fun mapToCourseInfo(coursesPreviewResult: CoursesPreviewResult): CourseInfo {
    return CourseInfo(title = coursesPreviewResult.title, tags = coursesPreviewResult.tags ?: listOf())
}

fun mapToCommunityNoteInfo(communityNotePreviewResult: CommunityNotePreviewResult): NoteCommunityInfo {
    return NoteCommunityInfo(
        noteCommonInfo = NoteCommonInfo(
            title = communityNotePreviewResult.data!!.title,
            description = communityNotePreviewResult.data!!.description,
            date = communityNotePreviewResult.data!!.date
        ),
        lastCommentatorFullName = "${communityNotePreviewResult.data!!.author.name} ${communityNotePreviewResult.data!!.author.surname}",
        lastCommentatorIconUrl = communityNotePreviewResult.data!!.author.avatarUrl
    )
}

fun mapToLocalNoteInfo(localNotePreview: LocalNotePreview): NoteCommonInfo {
    return NoteCommonInfo(
        title = localNotePreview.title,
        description = localNotePreview.description,
        date = localNotePreview.date
    )
}