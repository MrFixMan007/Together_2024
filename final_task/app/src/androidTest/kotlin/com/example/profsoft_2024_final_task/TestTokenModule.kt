package com.example.profsoft_2024_final_task

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.common.data.AuthenticatedApiRepository
import com.example.common.data.UnauthenticatedApiRepository
import com.example.network.AuthInterceptor
import com.example.network.TokenProvider
import com.example.network.api.AuthenticatedApiRepositoryImpl
import com.example.network.api.CourseApiService
import com.example.network.api.UnauthenticatedApiRepositoryImpl
import com.example.network.api.UserApiService
import com.example.profsoft_2024_final_task.app.di.AuthenticatedRetrofitClient
import com.example.profsoft_2024_final_task.app.di.NetworkModule
import com.example.profsoft_2024_final_task.app.di.UnauthenticatedRetrofitClient
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
        private const val DEV_BASE_URL = "http://profsoft.ddns.net:8080"
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
    fun provideUnauthenticatedRetrofit(@UnauthenticatedRetrofitClient okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
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

    @AuthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideAuthenticatedOkHttpClient(@ApplicationContext context: Context, tokenProvider: TokenProvider): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context = context))
            .addInterceptor(AuthInterceptor(tokenProvider = tokenProvider))
            .build()
    }

    @AuthenticatedRetrofitClient
    @Provides
    @Singleton
    fun provideAuthenticatedRetrofit(@AuthenticatedRetrofitClient okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
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
    fun provideAuthenticatedApiRepository(@AuthenticatedRetrofitClient retrofit: Retrofit): AuthenticatedApiRepository {
        return AuthenticatedApiRepositoryImpl(retrofit = retrofit)
    }

    @Provides
    @Singleton
    fun provideTestTokenProvider(): TokenProvider {
        return object : TokenProvider {
            override fun getToken(): String {
                return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJhdWQiLCJpc3MiOiJpc3N1ZXIiLCJpZCI6IjY2YzYzYTIxZTk0OTNmMWY0NjBkZmQ2OCIsInBob25lIjoiNzkyNzYwNTEyMzEiLCJwYXNzd29yZE1EIjoiMjVmOWU3OTQzMjNiNDUzODg1ZjUxODFmMWI2MjRkMGIiLCJleHAiOjE3MjQ2NzA4NzV9._mqToaUfLgPwU7Xc54Xac2RIel1i569SSEknYaNHH2o" // Тестовый токен
            }
        }
    }
}