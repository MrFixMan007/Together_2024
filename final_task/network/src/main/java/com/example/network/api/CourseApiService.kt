package com.example.network.api

import com.example.network.dto.authenticated.CourseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseApiService {

    @GET("/api/courses/{courseId}")
    suspend fun getCourseById(@Path("courseId") courseId: String): CourseResponse?

}