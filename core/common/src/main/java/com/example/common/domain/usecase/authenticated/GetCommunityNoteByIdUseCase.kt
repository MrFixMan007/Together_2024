package com.example.common.domain.usecase.authenticated

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.CommunityNote

class GetCommunityNoteByIdUseCase(private val apiRepository: AuthenticatedApiRepository) {
    suspend fun execute(id: String): CommunityNote? {
        return apiRepository.getCommunityNoteById(id)
    }
}