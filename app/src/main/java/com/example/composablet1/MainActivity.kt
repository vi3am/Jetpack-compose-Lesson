package com.example.composablet1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composablet1.counter_MVVM.CounterApp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composablet1.APIcalls.RecipeScreen
import com.example.composablet1.abanotification.screen.AbaNotification
import com.example.composablet1.counter_MVVM.CounterViewModel
import com.example.composablet1.ecommerce.EcommerceScreen
import com.example.composablet1.foods.FoodsOrderScreen
import com.example.composablet1.mvvmFirebase.AuthScreen
import com.example.composablet1.screen.LazyVertcalGridScreen
import com.example.composablet1.weatherAPI.WeatherScreen
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            val navController = rememberNavController()
//
//            NavHost(
//                navController = navController,
//                startDestination = "login"
//            ) {
//
//                composable("login") {
//                    AuthScreen(navController = navController)
//                }
//
//                composable("FoodsOrderScreen") {
//                    FoodsOrderScreen()
//                }
//
//            }
            EcommerceScreen()
//            LazyVertcalGridScreen()
        }
    }
}


