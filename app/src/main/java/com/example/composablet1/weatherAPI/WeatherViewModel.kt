package com.example.composablet1.weatherAPI

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    var weather by mutableStateOf<WeatherResponse?>(null)
        private set

    fun fetchWeather(city: String){
        viewModelScope.launch {
            try {
                weather = RetrofitInstance.api.getWeather(
                    city = city,
                    apiKey = "52b0012dc2bd62dc577d6cd95531b3b8"
                )
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}