package com.example.jpmorgan.openweathermap.ui.utils

class Utils {
    companion object {

        fun tempKelvinToCelsius(tempKelvin : Double) = String.format("%.2f", tempKelvin - 273.15)

        fun tempKelvinToFahrenheit(tempKelvin : Double) =
            String.format("%.2f", (9/5 * (tempKelvin - 273) + 32))
    }
}