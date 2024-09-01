package com.example.network.api

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.CommunityNotePreviewResult
import com.example.common.domain.model.authenticated.CoursesPreviewResult
import com.example.common.domain.model.authenticated.ResultMark
import com.example.network.mapToCommunityNotePreview
import com.example.network.mapToCourse
import retrofit2.HttpException
import retrofit2.Retrofit

class AuthenticatedApiRepositoryImpl(private val retrofit: Retrofit) : AuthenticatedApiRepository {

    override suspend fun getCourseById(id: String): CoursesPreviewResult? {
        val response = kotlin.runCatching {
            retrofit.create(CourseApiService::class.java).getCourseById(id)
        }
        response.onFailure {
            return null
        }
        response.getOrNull()?.data?.let {
            return mapToCourse(response.getOrNull()!!.data!!)
        } ?: return null
    }

    override suspend fun getAllCourses(): List<CoursesPreviewResult> {
        val response = kotlin.runCatching {
            retrofit.create(CourseApiService::class.java).getCourses()
        }
        response.onFailure {
            return listOf()
        }
        response.getOrNull()?.data?.let {
            return response.getOrNull()!!.data!!.map { mapToCourse(it) }
        } ?: return listOf()
    }

    override suspend fun getLastCommunityNote(): CommunityNotePreviewResult {
        val response = kotlin.runCatching {
            retrofit.create(NoteApiService::class.java).getNotes()
        }
        response.onFailure { throwable  ->
            if (throwable is HttpException) {
                if (throwable.code() == 401){
                    return CommunityNotePreviewResult(
                        resultMark = ResultMark.TokenIsNotValid
                    )
                }
            }
            return CommunityNotePreviewResult(
                resultMark = ResultMark.Error
            )
        }

        response.getOrNull()?.data?.let {
            return mapToCommunityNotePreview(response.getOrNull()!!.data.last())
        } ?: return CommunityNotePreviewResult(
            resultMark = ResultMark.Error
        )
    }
}