package com.example.jpmorgan.openweathermap.api.network

import com.example.jpmorgan.openweathermap.api.model.WeatherServiceResponse

sealed interface ResultState {
    data class Success(val weatherService: WeatherServiceResponse) : ResultState
    object Error : ResultState
    object Loading : ResultState
}