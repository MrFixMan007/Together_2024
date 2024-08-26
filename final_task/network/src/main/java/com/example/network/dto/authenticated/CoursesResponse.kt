package com.example.network.dto.authenticated

data class CoursesResponse(
    val status: Int,
    val message: String?,
    val data: List<CourseDto>?
)