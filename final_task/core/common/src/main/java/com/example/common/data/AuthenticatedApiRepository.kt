package com.example.common.data

import com.example.common.domain.model.authenticated.CommunityNotePreview
import com.example.common.domain.model.authenticated.Course

interface AuthenticatedApiRepository {
    suspend fun getCourseById(id: String): Course?
    suspend fun getAllCourses(): List<Course>
    suspend fun getLastCommunityNote(): CommunityNotePreview
//    suspend fun getAllCommunityNotes(): List<CommunityNotePreview>
//    suspend fun getCommunityNoteById(id: String): CommunityNote
}