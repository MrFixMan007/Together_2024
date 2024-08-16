package com.example.profsoft_2024_final_task.domain.model

data class RegisterUserParam(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val password: String
)
