package com.example.profsoft_2024_final_task.network

import android.util.Log
import com.example.network.api.CourseApiService
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class CoursesPreviewResultApiServiceTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: CourseApiService

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testGetCourseById() = runTest {
        val response = apiService.getCourseById(courseId = "66c641bde9493f1f460dfd69")
        Log.e("response", response.toString())
        assertNotNull(response)
    }


}