package com.example.common.domain.model.unauthenticated

data class AuthorizeUserParam(
    val phoneNumber: String,
    val password: String
)
