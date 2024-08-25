package com.example.network.dto.unauthenticated

data class AuthorizeUserResponse(
    val status: Int,
    val message: String?,
    val data: AuthorizeDataResponse?
)
data class AuthorizeDataResponse(
    val token: String,
)
