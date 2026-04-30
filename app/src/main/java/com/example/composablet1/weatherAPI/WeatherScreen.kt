package com.example.composablet1.weatherAPI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {

    val data = viewModel.weather

    LaunchedEffect(Unit) {
        viewModel.fetchWeather("Phnom Penh")
    }

    Column(modifier = Modifier.padding(16.dp)) {

        if (data == null) {
            Text("Loading...")
        } else {
            Text("Temp: ${data.main.temp}°C")
            Text("Condition: ${data.weather[0].description}")

            val iconUrl = "https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png"

            Image(
                painter = rememberAsyncImagePainter(iconUrl),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPre(){
     WeatherScreen()
}