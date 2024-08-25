package com.example.common.data

import com.example.common.domain.model.unauthenticated.AuthorizeResult
import com.example.common.domain.model.unauthenticated.AuthorizeUserParam
import com.example.common.domain.model.unauthenticated.RegisterResult
import com.example.common.domain.model.unauthenticated.RegisterUserParam

interface UnauthenticatedApiRepository {
    suspend fun userRegister(registerUserParam: RegisterUserParam) : RegisterResult
    suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam) : AuthorizeResult
    fun hashPassword(password: String): String
}