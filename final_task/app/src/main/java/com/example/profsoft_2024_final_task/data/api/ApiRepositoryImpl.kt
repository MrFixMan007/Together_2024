package com.example.profsoft_2024_final_task.data.api

import com.example.profsoft_2024_final_task.data.mapToRegisterUserRequestBody
import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam
import com.example.profsoft_2024_final_task.domain.repository.ApiRepository
import retrofit2.Retrofit

class ApiRepositoryImpl(private val retrofit: Retrofit) : ApiRepository {
    override suspend fun userRegister(registerUserParam: RegisterUserParam) {
        retrofit.create(UserApiService::class.java).registerUSer(body = mapToRegisterUserRequestBody(registerUserParam))
    }

    override suspend fun userAuthorize(authorizeUserParam: AuthorizeUserParam) {
        TODO("Not yet implemented")
    }
}