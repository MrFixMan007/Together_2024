package com.example.common.domain.usecase.authenticated

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.CoursesPreviewResult

class GetAllCoursesUseCase(private val apiRepository: AuthenticatedApiRepository) {
    suspend fun execute(): List<CoursesPreviewResult> {
        return apiRepository.getAllCourses()
    }
}