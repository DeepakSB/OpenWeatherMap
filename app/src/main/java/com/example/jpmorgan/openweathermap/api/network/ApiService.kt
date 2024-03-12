package com.example.jpmorgan.openweathermap.api.network

import com.example.jpmorgan.openweathermap.api.model.WeatherServiceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun getCityWeather(@Query("q") cityName: String) : WeatherServiceResponse
}