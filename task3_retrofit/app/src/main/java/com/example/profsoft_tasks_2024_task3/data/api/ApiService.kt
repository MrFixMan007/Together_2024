package com.example.profsoft_tasks_2024_task3.data.api

import com.example.profsoft_tasks_2024_task3.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/forecast")
    suspend fun getWeather(
        @Query("id") id: Int,
        @Query("appid") appid: String,
    ): WeatherDto
}