package com.example.jpmorgan.openweathermap.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.jpmorgan.openweathermap.api.model.City

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenWeatherScreen(
    navController: NavController

) {

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
                value = "",
                singleLine = true,
                label = {Text (stringResource(id = R.string.enter_city_name))},
                onValueChange = {

                },
                trailingIcon = {
                    IconButton(onClick = {

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
fun weatherServiceListScreen(cityList: List<City>,
                             modifier: Modifier = Modifier,
                             contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn(modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(
            count = cityList.size,
            key = {
                cityList[it].id
            },
            itemContent = {
                CityCard(it, cityList)
            }
        )
    }
}

@Composable
fun CityCard (i: Int,
              cityList: List<City>) {
    Card(
        modifier = Modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = cityList[i].name
            )
        }
    }
}