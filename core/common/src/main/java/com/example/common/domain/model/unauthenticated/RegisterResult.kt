package com.example.common.domain.model.unauthenticated

data class RegisterResult(
    val isSuccess: Boolean,
    val message: String?,
    val token: String?
)
