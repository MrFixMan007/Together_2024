package com.example.profsoft_2024_task4_retrofit_hilt.domain.usecase

import com.example.profsoft_2024_task4_retrofit_hilt.data.repository.IWeatherRepository
import com.example.profsoft_2024_task4_retrofit_hilt.domain.model.Weather

class GetWeatherUseCase(private val weatherRepository: IWeatherRepository) {
    suspend fun execute(cityId: Int): Weather {
        return weatherRepository.getWeather(cityId = cityId)
    }
}