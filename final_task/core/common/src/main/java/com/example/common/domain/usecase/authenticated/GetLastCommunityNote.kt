package com.example.common.domain.usecase.authenticated

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.CommunityNotePreview

class GetLastCommunityNoteUseCase(private val apiRepository: AuthenticatedApiRepository) {
    suspend fun execute(): CommunityNotePreview {
        return apiRepository.getLastCommunityNote()
    }
}