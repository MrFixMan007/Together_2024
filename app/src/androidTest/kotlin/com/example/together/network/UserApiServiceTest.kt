package com.example.together.network

import android.util.Log
import com.example.network.api.UserApiService
import com.example.network.dto.unauthenticated.AuthorizeUserRequestBody
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

//    @Test
//    fun testRegisterUser() = runTest {
//        val response = apiService.registerUSer(
//            RegisterUserRequestBody(
//                phone = "79271231327",
//                passwordHashed = "1bc29b36f623ba82aaf6724fd3b16719",
//                name = "Name",
//                surname = "surname",
//                avatar = "string"
//            )
//        )
//        Log.e("response", response.toString())
//        assertNotNull(response)
//    }

    @Test
    fun testAuthorizeUser() = runTest {
        val response = apiService.authorizeUser(
            AuthorizeUserRequestBody(
                phone = "79271231234",
                passwordHashed = "1bc29b36f623ba82aaf6724fd3b16718"
            )
        )
        Log.e("response", response.toString())
        assertNotNull(response)
    }
}