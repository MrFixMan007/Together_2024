package com.example.network.dto.authenticated.course

import com.example.network.dto.authenticated.TextDto

data class CourseDto(
    val id: String,
    val title: String,
    val description: String,
    val tags: List<String>,
    val text: List<TextDto>
)