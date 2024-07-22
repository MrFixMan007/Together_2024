package com.example.profsoft_tasks_2024_task3.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.profsoft_tasks_2024_task3.BuildConfig
import com.example.profsoft_tasks_2024_task3.R
import com.example.profsoft_tasks_2024_task3.WeatherMapper
import com.example.profsoft_tasks_2024_task3.data.api.ApiService
import com.example.profsoft_tasks_2024_task3.ui.model.Weather
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class NetworkViewModel(private val context: Context) : ViewModel() {
    val state: LiveData<Weather> get() = _state
    private val _state = MutableLiveData<Weather>()

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(ChuckerInterceptor(context = context))
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(DEV_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    init {
        viewModelScope.launch {
            getRequest()
        }
    }

    private suspend fun getRequest() {
        val response = kotlin.runCatching {
            retrofit.create(ApiService::class.java).getWeather(id = CITY_ID, appid = API_KEY)
        }

        response.onSuccess {
            Log.e("response", response.toString())
            _state.value = WeatherMapper.toWeather(response.getOrNull()!!)
        }
        response.onFailure {
            Log.e("response", "getRequest: Получить запрос не удалось")
            Toast.makeText(context, R.string.failMessage, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val READ_TIMEOUT_IN_SECONDS = 15L
        private const val CONNECTION_TIMEOUT_IN_SECONDS = 15L
        private const val DEV_BASE_URL = "https://api.openweathermap.org"
        private const val API_KEY = BuildConfig.API_KEY
        private const val CITY_ID = 498677
    }

    class MyNetworkViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NetworkViewModel::class.java)) {
                return NetworkViewModel(context = context) as T
            }
            return super.create(modelClass)
        }
    }
}