package com.example.network.dto.authenticated.note

data class NoteResponse(
    val status: Int,
    val message: String?,
    val data: NoteDto
)
