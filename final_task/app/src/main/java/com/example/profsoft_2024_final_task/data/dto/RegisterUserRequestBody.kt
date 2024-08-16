package com.example.profsoft_2024_final_task.data.dto

data class RegisterUserRequestBody(
    val phone: String,
    val passwordHashed: String,
    val name: String,
    val surname: String,
    val avatar: String?
)
