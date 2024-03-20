package com.example.jpmorgan.openweathermap.api.data

import com.example.jpmorgan.openweathermap.api.model.CityWeather
import com.example.jpmorgan.openweathermap.api.model.WeatherServiceData
import com.example.jpmorgan.openweathermap.api.network.ApiService
import com.example.jpmorgan.openweathermap.api.network.ResultState

interface WeatherServiceRepository {
    suspend fun getCityWeather(cityName: String): ResultState
    fun weatherServiceData() : WeatherServiceData
}

class WeatherServiceRepositoryImpl (private val apiService: ApiService) : WeatherServiceRepository {

    private val weatherServiceData = WeatherServiceData()
    override suspend fun getCityWeather(cityName: String): ResultState {
        try {
            val response = apiService.getCityWeather(cityName)
            if (response.cod == 200) {
                mapWeatherServiceData(response)
                return ResultState.Success(response)
            }
            return ResultState.Error(response.message)
        } catch (e : Exception) {

            return ResultState.Error("City not found")
        }
    }

    private fun mapWeatherServiceData(weatherServiceResponse : CityWeather) {
        weatherServiceData.temp = weatherServiceResponse.main.temp
        weatherServiceData.description = weatherServiceResponse.weather[0].description
        weatherServiceData.date = weatherServiceResponse.dt.toString()
        weatherServiceData.sunrise = weatherServiceResponse.sys.sunrise.toString()
        weatherServiceData.sunset = weatherServiceResponse.sys.sunset.toString()
        weatherServiceData.pressure = weatherServiceResponse.main.pressure
        weatherServiceData.windSpeed = weatherServiceResponse.wind.speed
        weatherServiceData.humidity = weatherServiceResponse.main.humidity
        weatherServiceData.windDirection = weatherServiceResponse.wind.deg.toString()
        weatherServiceData.cityName = weatherServiceResponse.name + ", " +
                                        weatherServiceResponse.sys.country
        weatherServiceData.visibility = (weatherServiceResponse.visibility/1000)
    }

    override fun weatherServiceData() : WeatherServiceData {
        return weatherServiceData
    }

}