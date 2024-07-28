package com.example.profsoft_2024_task4_retrofit_koin.ui.model

data class Weather(
    val cityName: String,
    val degreeTemp: String,
    val feelsDegreeTemp: String,
    val clouds: String,
    val minDegreeTemp: String,
    val maxDegreeTemp: String,
    val pressure: String,
    val humidity: String,
    val visibility: String,
    val windSpeed: String,
    val gust: String,
    val direction: String,
)
