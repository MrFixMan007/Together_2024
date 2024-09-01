package com.example.common.domain.model.authenticated

data class CoursesPreviewResult(
    val id: String,
    val title: String,
    val description: String,
    val tags: List<String>? = null,
    val text: List<Text>? = null
)