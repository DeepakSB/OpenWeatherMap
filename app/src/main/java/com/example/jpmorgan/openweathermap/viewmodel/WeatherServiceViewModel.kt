package com.example.jpmorgan.openweathermap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpmorgan.openweathermap.api.data.WeatherServiceRepository
import com.example.jpmorgan.openweathermap.api.model.WeatherServiceData
import com.example.jpmorgan.openweathermap.api.network.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherServiceViewModel @Inject internal constructor (
    private val weatherServiceRepository: WeatherServiceRepository
) : ViewModel() {

    val resultState = MutableStateFlow(ResultState.Loading(""))
    private val _cityWeatherServiceData = MutableStateFlow(WeatherServiceData())
    val cityWeatherServiceData: MutableStateFlow<WeatherServiceData> = _cityWeatherServiceData
    private val _weatherScreenUpdate = MutableStateFlow(false)
    val weatherScreenUpdate: MutableStateFlow<Boolean> = _weatherScreenUpdate
    private val _weatherError = MutableStateFlow(false)
    val weatherError: MutableStateFlow<Boolean> = _weatherError

    fun getCityWeather(cityName: String) {
        viewModelScope.launch {
            val result = weatherServiceRepository.getCityWeather(cityName)
            when (result) {
                is ResultState.Success -> {
                    _weatherError.value = false
                    _cityWeatherServiceData.value = weatherServiceRepository.weatherServiceData()
                    _weatherScreenUpdate.value = true
                }
                is ResultState.Error -> {
                    _weatherScreenUpdate.value = false
                    _weatherError.value = true
                }
                else -> {}
            }
        }
    }

    fun getWeatherServiceData() {
        _cityWeatherServiceData.value = weatherServiceRepository.weatherServiceData()
    }
}