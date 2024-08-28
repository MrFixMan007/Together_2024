package com.example.common.domain.model.authenticated

data class Author(
    val id: String,
    val name: String,
    val surname: String,
    val avatarUrl: String,
    val role: Int = 0
)
