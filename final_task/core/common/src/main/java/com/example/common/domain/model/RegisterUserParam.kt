package com.example.common.domain.model

data class RegisterUserParam(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val password: String
)
