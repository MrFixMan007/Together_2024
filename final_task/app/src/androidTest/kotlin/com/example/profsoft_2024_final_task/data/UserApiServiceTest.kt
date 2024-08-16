package com.example.profsoft_2024_final_task.data

import android.util.Log
import com.example.profsoft_2024_final_task.data.api.UserApiService
import com.example.profsoft_2024_final_task.data.dto.RegisterUserRequestBody
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class UserApiServiceTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiService: UserApiService

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testRegisterUser() = runTest {
        val response = apiService.registerUSer(
            RegisterUserRequestBody(
                phone = "79271231327",
                passwordHashed = "1bc29b36f623ba82aaf6724fd3b16719",
                name = "Name",
                surname = "surname",
                avatar = "string"
            )
        )
        Log.e("response", response.toString())
        assertNotNull(response)
    }
}