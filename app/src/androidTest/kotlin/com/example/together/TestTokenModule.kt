package com.example.together

import android.content.Context
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.common.data.AuthenticatedApiRepository
import com.example.common.data.UnauthenticatedApiRepository
import com.example.network.AuthInterceptor
import com.example.network.TokenProvider
import com.example.network.UserProvider
import com.example.network.api.AuthenticatedApiRepositoryImpl
import com.example.network.api.CourseApiService
import com.example.network.api.NoteApiService
import com.example.network.api.UnauthenticatedApiRepositoryImpl
import com.example.network.api.UserApiService
import com.example.together.di.AuthenticatedRetrofitClient
import com.example.together.di.NetworkModule
import com.example.together.di.UnauthenticatedRetrofitClient
import com.example.utils.PASSWORD_SHARED_PREFS
import com.example.utils.PHONE_SHARED_PREFS
import com.example.utils.TOKEN_SHARED_PREFS
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
class TestTokenModule {

    companion object {
        private const val READ_TIMEOUT_IN_SECONDS = 5L
        private const val CONNECTION_TIMEOUT_IN_SECONDS = 5L
        private const val DEV_BASE_URL = "http://test:8080" // укажи адрес
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @UnauthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideUnauthenticatedOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context = context))
            .build()
    }

    @UnauthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideUnauthenticatedRetrofit(
        @UnauthenticatedRetrofitClient okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(DEV_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideUserService(@UnauthenticatedRetrofitClient retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUnauthenticatedApiRepository(@UnauthenticatedRetrofitClient retrofit: Retrofit): UnauthenticatedApiRepository {
        return UnauthenticatedApiRepositoryImpl(retrofit = retrofit)
    }

    @Provides
    @Singleton
    fun provideUserProvider(@ApplicationContext context: Context): UserProvider {
        return object : UserProvider {
            val sharedPreferences = context.getSharedPreferences(TOKEN_SHARED_PREFS, MODE_PRIVATE)
            val myPhone = sharedPreferences.getString(PHONE_SHARED_PREFS, "").toString()
            val myPassword = sharedPreferences.getString(PASSWORD_SHARED_PREFS, "").toString()

            override fun getPhone(): String {
                return myPhone
            }

            override fun getPassword(): String {
                return myPassword
            }
        }
    }

    @AuthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideAuthenticatedOkHttpClient(
        @ApplicationContext context: Context,
        tokenProvider: TokenProvider,
        userApiService: UserApiService,
        userProvider: UserProvider,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context = context))
            .addInterceptor(
                AuthInterceptor(
                    tokenProvider = tokenProvider,
                    userApiService = userApiService,
                    userProvider = userProvider
                )
            )
            .build()
    }

    @AuthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideAuthenticatedRetrofit(
        @AuthenticatedRetrofitClient okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(DEV_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideCourseApiService(@AuthenticatedRetrofitClient retrofit: Retrofit): CourseApiService {
        return retrofit.create(CourseApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNoteApiService(@AuthenticatedRetrofitClient retrofit: Retrofit): NoteApiService {
        return retrofit.create(NoteApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthenticatedApiRepository(@AuthenticatedRetrofitClient retrofit: Retrofit): AuthenticatedApiRepository {
        return AuthenticatedApiRepositoryImpl(retrofit = retrofit)
    }

    @Provides
    @Singleton
    fun provideTestTokenProvider(): TokenProvider {
        return object : TokenProvider {
            override fun getToken(): String {
                return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJhdWQiLCJpc3MiOiJpc3N1ZXIiLCJpZCI6IjY2YzYzYTIxZTk0OTNmMWY0NjBkZmQ2OCIsInBob25lIjoiNzkyNzYwNTEyMzEiLCJwYXNzd29yZE1EIjoiMjVmOWU3OTQzMjNiNDUzODg1ZjUxODFmMWI2MjRkMGIiLCJleHAiOjE3MjQ4MTc5NjZ9.DlXEnXvNAeY_lA52on41x5eLEXs_sPeiX-DBJs7R5_k"
            }

            override fun setToken(newToken: String) {
                return
            }
        }
    }
}