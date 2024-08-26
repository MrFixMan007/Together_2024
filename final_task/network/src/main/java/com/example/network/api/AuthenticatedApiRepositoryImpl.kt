package com.example.network.api

import com.example.common.data.AuthenticatedApiRepository
import com.example.common.domain.model.authenticated.Course
import com.example.network.mapToCourse
import retrofit2.Retrofit

class AuthenticatedApiRepositoryImpl(private val retrofit: Retrofit) : AuthenticatedApiRepository {

    override suspend fun getCourseById(id: String): Course? {
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

    override suspend fun getAllCourses(): List<Course> {
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
}