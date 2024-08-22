package com.example.common.domain.model

data class RegisterResult(
    val isSuccess: Boolean,
    val message: String?,
    val token: String?
)
