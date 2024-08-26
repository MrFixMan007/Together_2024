package com.example.feature_main_screen

import com.example.common.domain.model.authenticated.Course
import com.example.ui.components.model.CourseInfo

fun mapToCourseInfo(course: Course): CourseInfo {
    return CourseInfo(title = course.title, tags = course.tags ?: listOf())
}