package com.example.common.data

import com.example.common.domain.model.authenticated.Course

interface AuthenticatedApiRepository {
    suspend fun getCourseById(id: String): Course
}