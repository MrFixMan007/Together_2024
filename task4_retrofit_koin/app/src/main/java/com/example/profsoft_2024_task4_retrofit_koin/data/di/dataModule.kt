package com.example.profsoft_2024_task4_retrofit_koin.data.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.profsoft_2024_task4_retrofit_koin.BuildConfig
import com.example.profsoft_2024_task4_retrofit_koin.data.repository.IWeatherRepository
import com.example.profsoft_2024_task4_retrofit_koin.data.repository.WeatherRepositoryApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    val READ_TIMEOUT_IN_SECONDS = 5L
    val CONNECTION_TIMEOUT_IN_SECONDS = 5L
    val DEV_BASE_URL = "https://api.openweathermap.org"

    factory<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context = get<Context>()))
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(DEV_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<IWeatherRepository> {
        WeatherRepositoryApi(retrofit = get(), apiKey = BuildConfig.API_KEY)
    }
}