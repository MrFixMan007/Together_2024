package com.example.network.dto.authenticated

data class Author(
    val id: String,
    val name: String,
    val surname: String,
    val avatar: String,
    val role: Int
)
