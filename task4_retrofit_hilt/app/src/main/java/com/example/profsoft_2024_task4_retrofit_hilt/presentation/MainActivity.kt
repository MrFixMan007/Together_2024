package com.example.profsoft_2024_task4_retrofit_hilt.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.profsoft_2024_task4_retrofit_hilt.BuildConfig
import com.example.profsoft_2024_task4_retrofit_hilt.domain.model.Weather
import com.example.profsoft_2024_task4_retrofit_hilt.presentation.viewmodel.NetworkViewModel
import com.example.profsoft_2024_task4_retrofit_hilt.R
import com.example.profsoft_2024_task4_retrofit_hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<NetworkViewModel>()
    private lateinit var context: Context
    private lateinit var degreeSymbol: String
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        context = binding.root.context
        setContentView(binding.root)
        init()
    }

    private fun init() {
        degreeSymbol = context.getString(R.string.degreeUnit)
        refreshLayout = binding.main

        if (BuildConfig.API_KEY == ""){
            Toast.makeText(context, R.string.noKeyMessage, Toast.LENGTH_SHORT).show()
            refreshLayout.setOnRefreshListener {
                refreshLayout.isRefreshing = false
            }
            return
        }

        refreshLayout.setOnRefreshListener {
            CoroutineScope(Dispatchers.Main).launch {
                refreshContent()
            }
        }

        viewModel.state.observe(this) {
            it?.let {
                renderWeather(it)
            }
                ?: notifyAboutWrongRequest()
        }

        viewModel.isRefreshing.observe(this) {
            refreshLayout.isRefreshing = it
        }
    }

    private suspend fun refreshContent() {
        viewModel.refresh()
    }

    private fun notifyAboutWrongRequest() {
        Toast.makeText(context, R.string.failMessage, Toast.LENGTH_SHORT).show()
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