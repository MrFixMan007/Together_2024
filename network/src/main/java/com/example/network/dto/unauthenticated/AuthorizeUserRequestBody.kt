package com.example.network.dto.unauthenticated

data class AuthorizeUserRequestBody(
    val phone: String,
    val passwordHashed: String,
)
