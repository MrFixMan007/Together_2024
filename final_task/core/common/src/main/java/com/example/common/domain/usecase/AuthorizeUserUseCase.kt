package com.example.common.domain.usecase

import com.example.common.data.ApiRepository
import com.example.common.domain.model.AuthorizeResult
import com.example.common.domain.model.AuthorizeUserParam

class AuthorizeUserUseCase(private val apiRepository: ApiRepository) {
    suspend fun execute(authorizeUserParam: AuthorizeUserParam): AuthorizeResult {
        return apiRepository.userAuthorize(authorizeUserParam)
    }
}