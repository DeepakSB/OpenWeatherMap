package com.example.jpmorgan.openweathermap

import android.app.Application
import com.example.jpmorgan.openweathermap.api.data.AppContainer
import com.example.jpmorgan.openweathermap.api.data.DefaultAppContainer

class WeatherServiceApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}