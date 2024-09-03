package com.example.common.data

import com.example.common.domain.model.authenticated.LocalNotePreview

interface DatabaseRepository {
    suspend fun getLastLocalNotePreview() : LocalNotePreview?
}