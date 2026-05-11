package com.example.composablet1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.room.Room
import com.example.composablet1.abanotification.screen.AbaNotification
import com.example.composablet1.appRoom.data.ContactDao
import com.example.composablet1.appRoom.data.ContactDatabase
import com.example.composablet1.appRoom.data.ContactScreen
import com.example.composablet1.appRoom.data.ContactViewModel
import com.example.composablet1.chipmongbankapp.screen.NotificationScreen
import com.example.composablet1.component.DatePickerScreen
import com.example.composablet1.component.DialogScreen
import com.example.composablet1.component.NavigationBarScreen
import com.example.composablet1.ecommerce.EcommerceScreen
import com.example.composablet1.foods.FoodsOrderScreen
import kotlin.getValue


class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "contact.db"
        ).build()
    }
    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val state by viewModel.state.collectAsState()
//            ContactScreen(
//                state = state,
//                onEvent = viewModel::onEvent
//            )

//            DatePickerScreen()
//            DialogScreen()
//            NavigationBarScreen()
//            FoodsOrderScreen()
//            NotificationScreen()
            AbaNotification()
        }
    }
}


