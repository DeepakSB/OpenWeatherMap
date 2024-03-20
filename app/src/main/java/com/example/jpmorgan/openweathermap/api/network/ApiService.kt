package com.example.jpmorgan.openweathermap.api.network

import com.example.jpmorgan.openweathermap.api.model.CityWeather
import com.example.jpmorgan.openweathermap.ui.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun getCityWeather(@Query("q") cityName: String,
                               @Query("APPID") appId : String = Constants.APP_ID) : CityWeather

}