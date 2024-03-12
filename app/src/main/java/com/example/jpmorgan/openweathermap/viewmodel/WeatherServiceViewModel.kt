package com.example.jpmorgan.openweathermap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpmorgan.openweathermap.api.network.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherServiceViewModel() : ViewModel() {

    val resultState = MutableStateFlow(ResultState.Loading)

    fun getCityWeather(cityName: String) {
        viewModelScope.launch {
            /*val response = weatherServiceRepository.getCityWeather(cityName)
            val code = response.cod*/
        }
    }
}