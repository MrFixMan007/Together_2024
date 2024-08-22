package com.example.network.dto

data class RegisterUserResponse(
    val status: Int,
    val message: String?,
    val data: RegisterDataResponse?
)

data class RegisterDataResponse(
    val token: String,
)
