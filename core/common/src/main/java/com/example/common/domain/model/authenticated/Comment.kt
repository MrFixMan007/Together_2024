package com.example.common.domain.model.authenticated

data class Comment(
    val id: String,
    val author: Author,
    val text: String
)