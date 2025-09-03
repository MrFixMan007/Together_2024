package com.example.database.repository

import com.example.common.data.DatabaseRepository
import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.database.MyDatabase
import com.example.database.mapToLocalNotePreview

class DatabaseRepositoryImpl(
    private val database: MyDatabase
) : DatabaseRepository {
    override suspend fun getLastLocalNotePreview(): LocalNotePreview? {
        val result = database.noteDao().getLastNote()
        return if (result != null) mapToLocalNotePreview(result) else null
    }
}