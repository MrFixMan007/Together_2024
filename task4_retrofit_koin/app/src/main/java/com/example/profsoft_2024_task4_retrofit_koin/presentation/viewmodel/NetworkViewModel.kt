package com.example.profsoft_2024_task4_retrofit_koin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profsoft_2024_task4_retrofit_koin.domain.model.Weather
import com.example.profsoft_2024_task4_retrofit_koin.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.launch

class NetworkViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val cityId: Int
) : ViewModel() {
    val state: LiveData<Weather?> get() = _state
    private val _state = MutableLiveData<Weather?>()


    init {
        viewModelScope.launch {
            getRequest()
        }
    }

    private suspend fun getRequest() {
        val response = kotlin.runCatching {
            getWeatherUseCase.execute(cityId)
        }
        response.onSuccess {
            Log.e("response", response.toString())
            _state.value = response.getOrNull()!!
        }
        response.onFailure {
            Log.e("response", "getRequest: Получить запрос не удалось")
            _state.value = null
        }
        Log.e("getRequest", _state.value.toString())
    }
}