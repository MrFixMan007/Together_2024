package com.example.profsoft_2024_final_task.domain.repository

import com.example.profsoft_2024_final_task.domain.model.AuthorizeResult
import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

interface ApiRepository {
    suspend fun userRegister(registerUserParam: RegisterUserParam) : String?
    suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam) : AuthorizeResult
    fun hashPassword(password: String): String
}