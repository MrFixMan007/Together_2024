package com.example.common.data

import com.example.common.domain.model.authenticated.CommunityNote
import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult

interface AuthenticatedApiRepository {
    suspend fun getCourseById(id: String): CoursesPreviewResult?
    suspend fun getAllCourses(): List<CoursesPreviewResult>
    suspend fun getLastCommunityNote(): CommunityNotePreviewResult
    suspend fun getCommunityNoteById(id: String): CommunityNote?
}