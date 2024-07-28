package com.example.profsoft_2024_task4_retrofit_koin

import com.example.profsoft_2024_task4_retrofit_koin.data.model.WeatherDto
import com.example.profsoft_2024_task4_retrofit_koin.domain.model.Weather

object WeatherMapper {
    private const val POSITION = 0
    fun toWeather(weatherDto: WeatherDto): Weather {
        val degrees = weatherDto.list[POSITION].wind.deg.toDouble()
        val direction = when {
            degrees < 0 || degrees >= 360 -> throw IllegalArgumentException("Degrees must be between 0 and 359")
            degrees in 0.0..11.25 -> "N"
            degrees in 11.25..33.75 -> "NNE"
            degrees in 33.75..56.25 -> "NE"
            degrees in 56.25..78.75 -> "ENE"
            degrees in 78.75..101.25 -> "E"
            degrees in 101.25..123.75 -> "ESE"
            degrees in 123.75..146.25 -> "SE"
            degrees in 146.25..168.75 -> "SSE"
            degrees in 168.75..191.25 -> "S"
            degrees in 191.25..213.75 -> "SSW"
            degrees in 213.75..236.25 -> "SW"
            degrees in 236.25..258.75 -> "WSW"
            degrees in 258.75..281.25 -> "W"
            degrees in 281.25..303.75 -> "WNW"
            degrees in 303.75..326.25 -> "NW"
            degrees in 326.25..348.75 -> "NNW"
            degrees in 348.75..360.0 -> "N"
            else -> throw IllegalStateException("Unexpected value: $degrees")
        }
        return Weather(
            cityName = weatherDto.city.name,
            degreeTemp = toDegree(weatherDto.list[POSITION].main.temp).toInt().toString(),
            feelsDegreeTemp = toDegree(weatherDto.list[POSITION].main.feels_like).toInt().toString(),
            clouds = weatherDto.list[POSITION].weather[0].description,
            minDegreeTemp = toDegree(weatherDto.list[POSITION].main.temp_min).toInt().toString(),
            maxDegreeTemp = toDegree(weatherDto.list[POSITION].main.temp_max).toInt().toString(),
            pressure = weatherDto.list[POSITION].main.pressure.toString(),
            humidity = weatherDto.list[POSITION].main.humidity.toString(),
            visibility = String.format("%+.1f", weatherDto.list[POSITION].visibility.toFloat() / 1000),
            windSpeed = String.format("%+.2f", weatherDto.list[POSITION].wind.speed),
            gust = String.format("%+.2f", weatherDto.list[POSITION].wind.gust),
            direction = direction,
        )
    }

    private fun toDegree(tempFahrenheit: Float): Float {
        return (tempFahrenheit - 32) * 5 / 9
    }
}