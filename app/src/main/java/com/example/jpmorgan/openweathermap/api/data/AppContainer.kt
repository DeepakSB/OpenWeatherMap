package com.example.jpmorgan.openweathermap.api.data

import com.example.jpmorgan.openweathermap.api.network.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val weatherServiceRepository : WeatherServiceRepository
}

@Module
@InstallIn(ActivityComponent::class)
class DefaultAppContainer : AppContainer {

    private val baseUrl = "https://api.openweathermap.org/"
    private val okHttp = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttp)
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