package com.example.profsoft_2024_task4_retrofit_hilt.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.profsoft_2024_task4_retrofit_hilt.BuildConfig
import com.example.profsoft_2024_task4_retrofit_hilt.data.repository.IWeatherRepository
import com.example.profsoft_2024_task4_retrofit_hilt.data.repository.WeatherRepositoryApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    companion object {
        private const val READ_TIMEOUT_IN_SECONDS = 5L
        private const val CONNECTION_TIMEOUT_IN_SECONDS = 5L
        private const val DEV_BASE_URL = "https://api.openweathermap.org"
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context = context))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(DEV_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(retrofit: Retrofit): IWeatherRepository{
        return WeatherRepositoryApi(retrofit = retrofit, apiKey = BuildConfig.API_KEY)
    }

    @Provides
    @Singleton
    fun provideNumber(): Int {
        return 498677
    }

}