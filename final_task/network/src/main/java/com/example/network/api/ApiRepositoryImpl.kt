package com.example.network.api

import com.example.common.data.ApiRepository
import com.example.common.domain.model.AuthorizeResult
import com.example.common.domain.model.AuthorizeUserParam
import com.example.common.domain.model.RegisterResult
import com.example.common.domain.model.RegisterUserParam
import com.example.network.mapToAuthorizeResult
import com.example.network.mapToAuthorizeUserRequestBody
import com.example.network.mapToRegisterResult
import com.example.network.mapToRegisterUserRequestBody
import retrofit2.Retrofit
import java.security.MessageDigest

class ApiRepositoryImpl(private val retrofit: Retrofit) : ApiRepository {
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
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(password.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}