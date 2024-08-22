package com.example.network.dto

data class AuthorizeUserRequestBody(
    val phone: String,
    val passwordHashed: String,
)
