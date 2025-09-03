package com.example.common.domain.model.authenticated

data class CommunityNote(
    val id: String,
    val title: String,
    val date: String,
    val author: Author,
    val text: List<Text>,
    val comments: List<Comment>
)