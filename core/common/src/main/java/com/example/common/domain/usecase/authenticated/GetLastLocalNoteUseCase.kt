package com.example.common.domain.usecase.authenticated

import com.example.common.data.DatabaseRepository
import com.example.common.domain.model.authenticated.LocalNotePreview

class GetLastLocalNoteUseCase(private val databaseRepository: DatabaseRepository) {
    suspend fun execute(): LocalNotePreview? {
        return databaseRepository.getLastLocalNotePreview()
    }
}