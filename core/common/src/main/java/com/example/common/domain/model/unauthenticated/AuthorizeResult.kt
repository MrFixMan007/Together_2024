package com.example.common.domain.model.unauthenticated

data class AuthorizeResult(
    val isSuccess: Boolean,
    val token: String?
)
