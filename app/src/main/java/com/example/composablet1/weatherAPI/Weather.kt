package com.example.composablet1.weatherAPI


data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String,
    val icon : String
)