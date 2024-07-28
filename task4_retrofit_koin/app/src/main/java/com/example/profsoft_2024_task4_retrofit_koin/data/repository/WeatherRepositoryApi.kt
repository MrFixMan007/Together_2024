package com.example.profsoft_2024_task4_retrofit_koin.data.repository

import com.example.profsoft_2024_task4_retrofit_koin.WeatherMapper
import com.example.profsoft_2024_task4_retrofit_koin.data.api.WeatherApi
import com.example.profsoft_2024_task4_retrofit_koin.domain.model.Weather
import retrofit2.Retrofit

class WeatherRepositoryApi(
    private val retrofit: Retrofit,
    private val apiKey: String,
) : IWeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        return WeatherMapper.toWeather(
            retrofit.create(WeatherApi::class.java).getWeather(id = cityId, appid = apiKey)
        )
    }
}