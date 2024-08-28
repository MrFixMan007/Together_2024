package com.example.common.domain.model.authenticated

data class CommunityNotePreview(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val author: Author
)