package com.example.common.domain.model

data class AuthorizeResult(
    val isSuccess: Boolean,
    val token: String?
)
