package com.example.profsoft_2024_task4_retrofit_hilt.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profsoft_2024_task4_retrofit_hilt.domain.model.Weather
import com.example.profsoft_2024_task4_retrofit_hilt.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val cityId: Int,
) : ViewModel() {
    val state: LiveData<Weather?> get() = _state
    private val _state = MutableLiveData<Weather?>()

    val isRefreshing: LiveData<Boolean> get() = _isRefreshing
    private val _isRefreshing = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch {
            getRequest()
        }
    }

    suspend fun refresh() {
        getRequest()
    }

    private suspend fun getRequest() {
        _isRefreshing.value = true
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
        _isRefreshing.value = false
    }
}