package com.example.jpmorgan.openweathermap.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jpmorgan.openweathermap.R
import com.example.jpmorgan.openweathermap.api.data.DefaultAppContainer
import com.example.jpmorgan.openweathermap.api.model.CityWeather
import com.example.jpmorgan.openweathermap.ui.utils.Utils
import com.example.jpmorgan.openweathermap.viewmodel.WeatherServiceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenWeatherScreen(
    navController: NavController,
) {
    val appContainer = DefaultAppContainer()
    val viewModel = WeatherServiceViewModel(appContainer.weatherServiceRepository)

    val cityName : MutableState<String> = remember {
        mutableStateOf("")
    }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.open_weather),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }
                })
        },
        ) {
        it
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            TextField(modifier = Modifier
                .fillMaxWidth(),
                readOnly = false,
                value = cityName.value,
                singleLine = true,
                label = {Text (stringResource(id = R.string.enter_city_name))},
                onValueChange = {
                    cityName.value = it
                },
                trailingIcon = {
                    IconButton(onClick = {
                        if(cityName.value.isNotEmpty()) {
                            viewModel.getCityWeather(cityName.value)
                        }
                    }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun WeatherServiceListScreen(cityWeatherList: List<CityWeather>,
                             modifier: Modifier = Modifier,
                             contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn(modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(
            count = cityWeatherList.size,
            key = {
                cityWeatherList[it].id
            },
            itemContent = {
                CityCard(it, cityWeatherList)
            }
        )
    }
}

@Composable
fun CityCard (i: Int,
              cityWeatherList: List<CityWeather>) {
    Card(
        modifier = Modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = cityWeatherList[i].name
            )
        }
    }
}

@Composable
fun WeatherScreen(cityWeather: CityWeather) {
    Column(
        modifier = Modifier.padding(top = 150.dp, bottom = 20.dp, start = 20.dp,
                                    end = 20.dp)
    ) {
        Text(
            text = cityWeather.name
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = stringResource(id = R.string.temperature_celsius,
            Utils.tempKelvinToCelsius(cityWeather.main.temp))
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = stringResource(id = R.string.humidity,
                cityWeather.main.humidity)
        )
    }
}