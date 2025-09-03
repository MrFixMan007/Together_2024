package com.example.network

import com.example.network.api.UserApiService
import com.example.network.dto.unauthenticated.AuthorizeUserRequestBody
import com.example.utils.hashPasswordMD5
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val tokenProvider: TokenProvider,
    private val userApiService: UserApiService,
    private val userProvider: UserProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider.getToken()
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        val response = chain.proceed(request)

        if (response.code() == 401) {
            synchronized(this) {
                val newToken = runBlocking {
                    refreshToken()
                }
                if (!newToken.isNullOrEmpty()) {
                    tokenProvider.setToken(newToken = newToken)
                    response.close()
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $newToken")
                        .build()
                    return chain.proceed(newRequest)
                }
            }
        }
        return response
    }

    private suspend fun refreshToken(): String? {
        val response = kotlin.runCatching {
            userApiService.authorizeUser(
                body = AuthorizeUserRequestBody(
                    phone = userProvider.getPhone(),
                    passwordHashed = hashPasswordMD5(userProvider.getPassword())
                )
            )
        }
        response.onFailure {
            return null
        }
        return response.getOrNull()?.data?.token
    }
}

interface TokenProvider {
    fun getToken(): String
    fun setToken(newToken: String)
}

interface UserProvider {
    fun getPhone(): String
    fun getPassword(): String
}