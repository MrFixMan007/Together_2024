package com.example.common.domain.usecase

import com.example.common.data.ApiRepository
import com.example.common.domain.model.RegisterResult
import com.example.common.domain.model.RegisterUserParam

class RegisterUserUseCase(private val apiRepository: ApiRepository) {
    suspend fun execute(registerUserParam: RegisterUserParam): RegisterResult {
        return apiRepository.userRegister(registerUserParam)
    }
}