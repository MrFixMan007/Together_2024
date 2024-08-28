package com.example.network.dto.authenticated.note

data class NotesResponse(
    val status: Int,
    val message: String?,
    val data: List<NoteDto>
)
