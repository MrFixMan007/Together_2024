package com.example.profsoft_2024_task4_retrofit_hilt.data.repository

import com.example.profsoft_2024_task4_retrofit_hilt.domain.model.Weather

interface IWeatherRepository {
    suspend fun getWeather(cityId: Int): Weather
}