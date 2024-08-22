package com.example.common.data

import com.example.common.domain.model.AuthorizeResult
import com.example.common.domain.model.AuthorizeUserParam
import com.example.common.domain.model.RegisterResult
import com.example.common.domain.model.RegisterUserParam

interface ApiRepository {
    suspend fun userRegister(registerUserParam: RegisterUserParam) : RegisterResult
    suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam) : AuthorizeResult
    fun hashPassword(password: String): String
}