package com.example.profsoft_2024_task4_retrofit_hilt.data.model

data class WeatherDto(
    val cod:Int,
    val message:String,
    val cnt:Int,
    val city: CityDto,
    val list: List<MoreInfoDto>
)

data class CityDto(
    val id: Long,
    val name: String,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Long,
    val sunset: Long,
    val coord: CoordDto
)

data class CoordDto(
    val lat: Float,
    val lon: Float,
)

data class MoreInfoDto(
    val dt: Long,
    val main: MainInfoDto,
    val weather: List<ShortInfoDto>,
    val wind: WindDto,
    val visibility: Int
)

data class MainInfoDto(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val temp_kf: Float,
)

data class ShortInfoDto(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)

data class WindDto(
    val speed: Float,
    val deg: Int,
    val gust: Float
)