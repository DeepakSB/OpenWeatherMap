package com.example.jpmorgan.openweathermap.api.data

import com.example.jpmorgan.openweathermap.api.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val weatherServiceRepository : WeatherServiceRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://api.openweathermap.org/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val weatherServiceRepository: WeatherServiceRepository by lazy {
        WeatherServiceRepositoryImpl(retrofitService)
    }
}