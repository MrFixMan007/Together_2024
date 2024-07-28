package com.example.profsoft_2024_task4_retrofit_koin.domain.usecase

import com.example.profsoft_2024_task4_retrofit_koin.data.repository.IWeatherRepository
import com.example.profsoft_2024_task4_retrofit_koin.domain.model.Weather

class GetWeatherUseCase(private val weatherRepository: IWeatherRepository) {
    suspend fun execute(cityId: Int): Weather {
        return weatherRepository.getWeather(cityId = cityId)
    }
}