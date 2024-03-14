package com.example.jpmorgan.openweathermap.api.data

import com.example.jpmorgan.openweathermap.api.model.CityWeather
import com.example.jpmorgan.openweathermap.api.network.ApiService

interface WeatherServiceRepository {
    suspend fun getCityWeather(cityName: String): CityWeather
}

class WeatherServiceRepositoryImpl (private val apiService: ApiService) : WeatherServiceRepository {
    override suspend fun getCityWeather(cityName: String): CityWeather =
            apiService.getCityWeather(cityName)
}