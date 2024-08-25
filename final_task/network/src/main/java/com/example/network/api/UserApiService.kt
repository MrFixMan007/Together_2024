package com.example.network.api

import com.example.network.dto.unauthenticated.AuthorizeUserRequestBody
import com.example.network.dto.unauthenticated.AuthorizeUserResponse
import com.example.network.dto.unauthenticated.RegisterUserRequestBody
import com.example.network.dto.unauthenticated.RegisterUserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("/api/register")
    suspend fun registerUser(@Body body: RegisterUserRequestBody?): RegisterUserResponse?

    @POST("/api/auth")
    suspend fun authorizeUser(@Body body: AuthorizeUserRequestBody?): AuthorizeUserResponse?
}