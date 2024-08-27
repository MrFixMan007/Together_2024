package com.example.network.dto.authenticated

data class Comment(
    val id: String,
    val author: Author,
    val text: String
)
