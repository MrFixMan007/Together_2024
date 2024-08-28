package com.example.network.dto.authenticated.note

import com.example.network.dto.authenticated.AuthorDto
import com.example.network.dto.authenticated.Comment
import com.example.network.dto.authenticated.TextDto

data class NoteDto(
    val id: String,
    val title: String,
    val content: List<TextDto>,
    val author: AuthorDto,
    val date: String,
    val comments: List<Comment>
)
