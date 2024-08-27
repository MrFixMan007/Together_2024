package com.example.profsoft_2024_final_task.data

import android.util.Log
import com.example.network.TokenProvider
import com.example.network.api.CourseApiService
import com.example.network.api.NoteApiService
import dagger.Provides
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidTest
class NoteApiServiceTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: NoteApiService

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testGetCourseById() = runTest {
        val response = apiService.getNoteById(noteId = "66ba4b51a78cb71cee5542ef")
        Log.e("response", response.toString())
        assertNotNull(response)
    }


}