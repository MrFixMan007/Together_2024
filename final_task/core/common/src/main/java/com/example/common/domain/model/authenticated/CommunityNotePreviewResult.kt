package com.example.common.domain.model.authenticated

data class CommunityNotePreviewResult(
    val resultMark: ResultMark = ResultMark.Success,
    val data: CommunityNotePreview? = null,
)

data class CommunityNotePreview(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val author: Author
)