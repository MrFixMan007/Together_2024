package com.example.profsoft_2024_final_task.data.api

import com.example.profsoft_2024_final_task.data.mapToAuthorizeResult
import com.example.profsoft_2024_final_task.data.mapToAuthorizeUserRequestBody
import com.example.profsoft_2024_final_task.data.mapToRegisterUserRequestBody
import com.example.profsoft_2024_final_task.domain.model.AuthorizeResult
import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam
import com.example.profsoft_2024_final_task.domain.repository.ApiRepository
import retrofit2.Retrofit
import java.security.MessageDigest

class ApiRepositoryImpl(private val retrofit: Retrofit) : ApiRepository {
    override suspend fun userRegister(registerUserParam: RegisterUserParam): String? {
        val response = retrofit.create(UserApiService::class.java)
            .registerUser(body = mapToRegisterUserRequestBody(registerUserParam))
        return response?.data?.token
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