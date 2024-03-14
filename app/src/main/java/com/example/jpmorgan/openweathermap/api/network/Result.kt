package com.example.jpmorgan.openweathermap.api.network

import com.example.jpmorgan.openweathermap.api.model.CityWeather

sealed interface ResultState {
    data class Success(val weatherService: CityWeather) : ResultState
    object Error : ResultState
    object Loading : ResultState
}