package com.example.common.domain.usecase.unauthenticated

import com.example.common.data.UnauthenticatedApiRepository
import com.example.common.domain.model.unauthenticated.RegisterResult
import com.example.common.domain.model.unauthenticated.RegisterUserParam

class RegisterUserUseCase(private val apiRepository: UnauthenticatedApiRepository) {
    suspend fun execute(registerUserParam: RegisterUserParam): RegisterResult {
        return apiRepository.userRegister(registerUserParam)
    }
}