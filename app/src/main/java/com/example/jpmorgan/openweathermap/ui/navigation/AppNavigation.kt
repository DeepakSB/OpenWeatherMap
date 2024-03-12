package com.example.jpmorgan.openweathermap.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jpmorgan.openweathermap.ui.compose.LoginScreen
import com.example.jpmorgan.openweathermap.ui.compose.OpenWeatherScreen
import com.example.jpmorgan.openweathermap.ui.theme.OpenWeatherAppTheme
import com.example.jpmorgan.openweathermap.ui.utils.Constants


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    OpenWeatherAppTheme {
        NavHost(
            navController = navController,
            startDestination = Constants.LOGIN_SCREEN,
            modifier = modifier
        ) {
            composable(route = Constants.LOGIN_SCREEN) {
                LoginScreen(navController)
            }
            composable(route = Constants.WEATHER_SCREEN) {
                OpenWeatherScreen(navController)
            }
        }
    }
}