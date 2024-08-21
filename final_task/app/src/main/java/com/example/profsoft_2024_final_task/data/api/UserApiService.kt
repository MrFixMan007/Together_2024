package com.example.profsoft_2024_final_task.data.api

import com.example.profsoft_2024_final_task.data.dto.AuthorizeUserRequestBody
import com.example.profsoft_2024_final_task.data.dto.AuthorizeUserResponse
import com.example.profsoft_2024_final_task.data.dto.RegisterUserRequestBody
import com.example.profsoft_2024_final_task.data.dto.RegisterUserResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface UserApiService {

    @POST("/api/register")
    suspend fun registerUser(@Body body: RegisterUserRequestBody?): RegisterUserResponse?

    @POST("/api/auth")
    suspend fun authorizeUser(@Body body: AuthorizeUserRequestBody?): AuthorizeUserResponse?

}