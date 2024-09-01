package com.example.common.domain.usecase.authenticated

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.CoursesPreviewResult

class GetCourseByIdUseCase(private val apiRepository: AuthenticatedApiRepository) {
    suspend fun execute(id: String): CoursesPreviewResult? {
        return apiRepository.getCourseById(id)
    }
}