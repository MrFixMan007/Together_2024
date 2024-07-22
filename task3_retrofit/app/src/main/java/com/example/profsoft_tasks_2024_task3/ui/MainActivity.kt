package com.example.profsoft_tasks_2024_task3.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.profsoft_tasks_2024_task3.R
import com.example.profsoft_tasks_2024_task3.databinding.ActivityMainBinding
import com.example.profsoft_tasks_2024_task3.ui.model.Weather
import com.example.profsoft_tasks_2024_task3.ui.viewmodel.NetworkViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<NetworkViewModel> {
        NetworkViewModel.MyNetworkViewModelFactory(
            this
        )
    }
    private lateinit var context: Context
    private lateinit var degreeSymbol: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        context = binding.root.context
        degreeSymbol = context.getString(R.string.degreeUnit)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            renderWeather(it)
        }
    }

    private fun renderWeather(weather: Weather) {
        binding.apply {
            textViewCity.text = weather.cityName
            textViewTemp.text = String.format("%s${degreeSymbol}", weather.degreeTemp)
            textViewFeelsTempAndClouds.text = String.format(
                "%s %s${degreeSymbol}, %s",
                context.getString(R.string.feelsLike),
                weather.feelsDegreeTemp,
                weather.clouds
            )
            textViewDetails.text = String.format(
                "%s: %s%s, %s:%s%s\n" +
                        "%s: %s %s\n" +
                        "%s: %s%s\n" +
                        "%s: %s %s",
                context.getString(R.string.min),
                weather.minDegreeTemp,
                degreeSymbol,
                context.getString(R.string.max),
                weather.maxDegreeTemp,
                degreeSymbol,
                context.getString(R.string.pressure),
                weather.pressure,
                context.getString(R.string.hpa),
                context.getString(R.string.humidity),
                weather.humidity,
                "%",
                context.getString(R.string.visibility),
                weather.visibility,
                context.getString(R.string.km),
            )
            textViewWind.text = String.format(
                "%s: %s %s\n" +
                        "%s: %s %s\n" +
                        "%s: %s",
                context.getString(R.string.windSpeed),
                weather.windSpeed,
                context.getString(R.string.ms),
                context.getString(R.string.gust),
                weather.gust,
                context.getString(R.string.ms),
                context.getString(R.string.direction),
                weather.direction,
            )
        }
    }
}