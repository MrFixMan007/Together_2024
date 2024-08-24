package com.example.ui.components.model

data class NoteCommunityInfo(
    val noteCommonInfo: NoteCommonInfo,
    val lastCommentatorFullName: String? = null,
    val lastCommentatorIconUrl: String? = null
)
