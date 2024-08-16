package com.example.profsoft_2024_final_task.data.dto

data class RegisterUserResponse(
    val data: DataResponse
)

data class DataResponse(
    val token: String,
)
