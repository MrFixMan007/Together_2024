package com.example.network.dto

data class RegisterUserRequestBody(
    val phone: String,
    val passwordHashed: String,
    val name: String,
    val surname: String,
    val avatar: String?
)
