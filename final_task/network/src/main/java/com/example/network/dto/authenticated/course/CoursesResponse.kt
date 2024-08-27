package com.example.network.dto.authenticated.course

data class CoursesResponse(
    val status: Int,
    val message: String?,
    val data: List<CourseDto>?
)