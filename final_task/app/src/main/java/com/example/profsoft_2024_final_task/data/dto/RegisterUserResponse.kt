package com.example.profsoft_2024_final_task.data.dto

data class RegisterUserResponse(
    val data: RegisterDataResponse
)

data class RegisterDataResponse(
    val token: String,
)
