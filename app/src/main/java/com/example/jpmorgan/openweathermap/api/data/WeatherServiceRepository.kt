package com.example.jpmorgan.openweathermap.api.data

import com.example.jpmorgan.openweathermap.api.model.WeatherServiceResponse
import com.example.jpmorgan.openweathermap.api.network.ApiService

interface WeatherServiceRepository {
    suspend fun getCityWeather(cityName: String): WeatherServiceResponse
}

class WeatherServiceRepositoryImpl (private val apiService: ApiService) : WeatherServiceRepository {
    override suspend fun getCityWeather(cityName: String): WeatherServiceResponse =
            apiService.getCityWeather(cityName)
}