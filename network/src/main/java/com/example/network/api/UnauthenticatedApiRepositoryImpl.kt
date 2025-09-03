package com.example.network.api

import com.example.common.data.UnauthenticatedApiRepository
import com.example.common.domain.model.unauthenticated.AuthorizeResult
import com.example.common.domain.model.unauthenticated.AuthorizeUserParam
import com.example.common.domain.model.unauthenticated.RegisterResult
import com.example.common.domain.model.unauthenticated.RegisterUserParam
import com.example.network.mapToAuthorizeResult
import com.example.network.mapToAuthorizeUserRequestBody
import com.example.network.mapToRegisterResult
import com.example.network.mapToRegisterUserRequestBody
import com.example.utils.hashPasswordMD5
import retrofit2.Retrofit

class UnauthenticatedApiRepositoryImpl(private val retrofit: Retrofit) : UnauthenticatedApiRepository {
    override suspend fun userRegister(registerUserParam: RegisterUserParam): RegisterResult {
        val param = registerUserParam.copy(password = hashPassword(registerUserParam.password))
        val response = kotlin.runCatching {
            retrofit.create(UserApiService::class.java).registerUser(
                body = mapToRegisterUserRequestBody(param)
            )
        }
        response.onFailure {
            return mapToRegisterResult(null)
        }

        return mapToRegisterResult(response.getOrNull())
    }

    override suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam): AuthorizeResult {
        val param = authorizeUserParam.copy(password = hashPassword(authorizeUserParam.password))
        val response = kotlin.runCatching {
            retrofit.create(UserApiService::class.java).authorizeUser(
                body = mapToAuthorizeUserRequestBody(param)
            )
        }
        response.onFailure {
            return mapToAuthorizeResult(null)
        }

        return mapToAuthorizeResult(response.getOrNull())
    }

    override fun hashPassword(password: String): String {
        return hashPasswordMD5(password = password)
    }
}