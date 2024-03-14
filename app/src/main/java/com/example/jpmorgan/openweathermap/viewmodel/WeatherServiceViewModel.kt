package com.example.jpmorgan.openweathermap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpmorgan.openweathermap.api.data.WeatherServiceRepository
import com.example.jpmorgan.openweathermap.api.network.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class WeatherServiceViewModel @Inject internal constructor (
    private val weatherServiceRepository: WeatherServiceRepository
) : ViewModel() {

    val resultState = MutableStateFlow(ResultState.Loading)

    fun getCityWeather(cityName: String) {
        viewModelScope.launch {
            val response = weatherServiceRepository.getCityWeather(cityName)
            if (response.cod == 200) {
                val id = response.id
            }
        }
    }
}