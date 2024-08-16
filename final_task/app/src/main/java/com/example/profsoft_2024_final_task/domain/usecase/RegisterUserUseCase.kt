package com.example.profsoft_2024_final_task.domain.usecase

import com.example.profsoft_2024_final_task.domain.repository.ApiRepository
import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

class RegisterUserUseCase(private val apiRepository: ApiRepository) {
    suspend fun execute(registerUserParam: RegisterUserParam) {
        apiRepository.userRegister(registerUserParam)
    }
}