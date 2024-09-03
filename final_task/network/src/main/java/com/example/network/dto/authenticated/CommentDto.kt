package com.example.network.dto.authenticated

data class CommentDto(
    val id: String,
    val author: AuthorDto,
    val text: String
)
