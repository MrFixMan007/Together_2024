package com.example.profsoft_2024_task4_retrofit_koin.data.api

import com.example.profsoft_2024_task4_retrofit_koin.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/forecast")
    suspend fun getWeather(
        @Query("id") id: Int,
        @Query("appid") appid: String,
    ): WeatherDto
}