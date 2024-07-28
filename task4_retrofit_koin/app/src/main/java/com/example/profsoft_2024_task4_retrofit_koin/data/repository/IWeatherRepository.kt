package com.example.profsoft_2024_task4_retrofit_koin.data.repository

import com.example.profsoft_2024_task4_retrofit_koin.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeather(cityId: Int): Weather
}