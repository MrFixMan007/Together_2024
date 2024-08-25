package com.example.common.domain.usecase.unauthenticated

import com.example.common.data.UnauthenticatedApiRepository
import com.example.common.domain.model.unauthenticated.AuthorizeResult
import com.example.common.domain.model.unauthenticated.AuthorizeUserParam

class AuthorizeUserUseCase(private val apiRepository: UnauthenticatedApiRepository) {
    suspend fun execute(authorizeUserParam: AuthorizeUserParam): AuthorizeResult {
        return apiRepository.userAuthorize(authorizeUserParam)
    }
}