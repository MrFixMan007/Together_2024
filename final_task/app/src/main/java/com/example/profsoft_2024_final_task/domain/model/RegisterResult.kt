package com.example.profsoft_2024_final_task.domain.model

data class RegisterResult(
    val isSuccess: Boolean,
    val message: String?,
    val token: String?
)
