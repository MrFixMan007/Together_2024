package com.example.profsoft_2024_final_task.data.dto

data class AuthorizeUserResponse(
    val data: AuthorizeDataResponse
)
data class AuthorizeDataResponse(
    val token: String,
)
