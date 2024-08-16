package com.example.profsoft_2024_final_task.domain.repository

import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

interface ApiRepository {
    suspend fun userRegister(registerUserParam: RegisterUserParam)
    suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam)
}