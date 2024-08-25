package com.example.network.dto.authenticated

data class CourseResponse(
    val status: Int,
    val message: String?,
    val data: CourseDto?
)

data class CourseDto(
    val id: String,
    val title: String,
    val description: String,
    val tags: List<String>,
    val text: List<TextDto>
)