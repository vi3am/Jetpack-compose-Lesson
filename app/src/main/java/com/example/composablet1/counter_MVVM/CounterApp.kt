package com.example.composablet1.counter_MVVM

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterApp(viewModel: CounterViewModel){
    Scaffold() {paddingValues ->
//        val counter = remember { mutableStateOf(0) }
//        fun increase(){
//            counter.value++
//        }
//        fun decrease(){
//            counter.value--
//        }
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Counter: ${viewModel.count.value}",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
               modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                        if(viewModel.count.value == 10){
                            viewModel.count.value = 0
                        }else{
                            viewModel.increase()
                        }
                    },
                    content = {
                        Text(
                            text = "Increase"
                        )
                    },
                )
                Spacer(modifier = Modifier.width(24.dp))
                Button(
                    onClick = {
                        if(viewModel.count.value > 0) viewModel.decrease()
                    },
                    content = {
                        Text(
                            text = "Decrease"
                        )
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun CounterAppPre(){
    val viewModel: CounterViewModel = viewModel()
    CounterApp(viewModel)
}