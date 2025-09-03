package com.example.network.dto.authenticated.note

import com.example.network.dto.authenticated.TextDto

data class TextNoteDto(
    val title: String,
    val content: List<TextDto>
)
