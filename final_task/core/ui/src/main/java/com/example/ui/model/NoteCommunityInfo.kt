package com.example.ui.model

data class NoteCommunityInfo(
    val noteCommonInfo: NoteCommonInfo,
    val lastCommentatorFullName: String? = null,
    val lastCommentatorIconUrl: String? = null
)
