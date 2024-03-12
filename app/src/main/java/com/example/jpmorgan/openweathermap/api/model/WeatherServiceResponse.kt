package com.example.jpmorgan.openweathermap.api.model

import kotlinx.serialization.SerialName

data class WeatherServiceResponse (val message: String,
        val cod: String, val count: Int,
        val list: List<City>)

data class City(val id: Double, val name: String, val coord: Coordinates,
                val main: WeatherParameters, val dt: Double,
                val wind: Wind, val sys: Country, val rain: String,
                val snow: String, val clouds: Clouds, val weather: List<Weather>)

data class Coordinates(val lat: Double, val lon: Double)

data class WeatherParameters(val temp: Double, val pressure: Double,
                             val humidity: Int,
                             @SerialName("temp_min") val tempMin: Double,
                             @SerialName("temp_max") val tempMax: Double)

data class Wind(val speed: Double, val deg: Double)

data class Country(val country: String)

data class Clouds(val all: Double)

data class Weather(val id: Double, val main: String, val description: String,
                   val icon: String)



