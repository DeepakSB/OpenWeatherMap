package com.example.jpmorgan.openweathermap.api.network

import com.example.jpmorgan.openweathermap.api.model.CityWeather

sealed interface ResultState {
    data class Success(val weatherService: CityWeather) : ResultState
    data class Error (val errorMsg: String) : ResultState
    data class Loading (val loadingMsg: String) : ResultState
}