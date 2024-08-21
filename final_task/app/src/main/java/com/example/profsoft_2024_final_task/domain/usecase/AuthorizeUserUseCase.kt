package com.example.profsoft_2024_final_task.domain.usecase

import com.example.profsoft_2024_final_task.domain.model.AuthorizeResult
import com.example.profsoft_2024_final_task.domain.repository.ApiRepository
import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam

class AuthorizeUserUseCase(private val apiRepository: ApiRepository) {
    suspend fun execute(authorizeUserParam: AuthorizeUserParam): AuthorizeResult {
        return apiRepository.userAuthorize(authorizeUserParam)
    }
}