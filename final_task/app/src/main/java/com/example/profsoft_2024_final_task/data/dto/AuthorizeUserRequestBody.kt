package com.example.profsoft_2024_final_task.data.dto

data class AuthorizeUserRequestBody(
    val phone: String,
    val passwordHashed: String,
)
