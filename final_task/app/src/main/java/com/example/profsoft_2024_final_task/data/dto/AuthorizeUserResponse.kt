package com.example.profsoft_2024_final_task.data.dto

data class AuthorizeUserResponse(
    val status: Int,
    val message: String?,
    val data: AuthorizeDataResponse?
)
data class AuthorizeDataResponse(
    val token: String,
)
