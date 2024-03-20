package com.example.jpmorgan.openweathermap.api.model

import com.google.gson.annotations.SerializedName

data class WeatherServiceSearchResponse (val message: String,
        val cod: String, val count: Int,
        val list: List<CityWeather>)

data class CityWeather(val id: Double, val name: String, val coord: Coordinates,
                       val main: WeatherParameters, val dt: Double,
                       val visibility: Double, val wind: Wind, val sys: Country, val rain: String,
                       val snow: String, val clouds: Clouds, val weather: List<Weather>,
                       val cod: Int, val timezone: Double,
                       val message: String)
data class Coordinates(val lat: Double, val lon: Double)

data class WeatherParameters(val temp: Double, val pressure: Double,
                             val humidity: Int,
                             @SerializedName("temp_min") val tempMin: Double,
                             @SerializedName("temp_max") val tempMax: Double)

data class Wind(val speed: Double, val deg: Double)

data class Country(val type: Int, val id: Double, val country: String,
                   val sunrise: Double, val sunset: Double)

data class Clouds(val all: Double)

data class Weather(val id: Double, val main: String, val description: String,
                   val icon: String)



