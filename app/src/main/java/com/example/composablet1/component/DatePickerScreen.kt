package com.example.composablet1.component

import android.R.attr.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composablet1.foods.AppBarTOP

@Composable
fun DatePickerScreen(){
    Scaffold(
        topBar = { AppBarTOP() }
    ) {padding  ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }

    }
}

@Preview
@Composable
fun PreviewScreen(){
    DatePickerScreen()
}