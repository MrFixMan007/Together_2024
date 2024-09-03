package com.example.database

import com.example.common.domain.model.authenticated.LocalNotePreview
import com.example.database.entity.NoteEntity

fun mapToLocalNotePreview(noteEntity: NoteEntity): LocalNotePreview{
    return LocalNotePreview(
        id = noteEntity.id.toString(),
        title = noteEntity.title,
        date = noteEntity.date,
        description = noteEntity.description
    )
}