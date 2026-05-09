package com.example.composablet1.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.composablet1.foods.AppBarTOP
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen() {
    val state = rememberDatePickerState()
//        val datePickerState = rememberDatePickerState()
    val selectedDate = state.selectedDateMillis?.let {
        convertDate(it, DateformatPatten.EEEE_dd_MMMM_yyyy.value)
    } ?: ""

    var showDatePicker by remember { mutableStateOf(false) }
    Scaffold(
        topBar = { AppBarTOP() },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showDatePicker = true
                },
                ) {
                Text("Show DatePicker")
            }
        }
    ) { padding ->


        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = selectedDate,
                fontSize = 16.sp
            )
            if (showDatePicker) {
                Popup(
                    onDismissRequest = {
                        showDatePicker = false
                    }
                ) {
                    DatePicker(
                        state = state,
                    )
                }

            }
        }
    }
}



fun convertDate(millis: Long, pattern: String): String {
    val formatter = SimpleDateFormat(pattern, Locale.getDefault())
    return formatter.format(Date(millis))
}

enum class DateformatPatten(val value: String) {
    DD_MM_YYYY("dd/MM/yyyy"),
    YYYY_MM_DD("yyyy-MM-dd"),
    dd_MM_yyyy_HH_mm("dd-MM-yyyy HH:mm"),
    EEEE_dd_MMMM_yyyy("EEEE, dd MMMM yyyy"),
    hh_mm_a("hh:mm a")
}


@Preview
@Composable
fun PreviewScreen() {
    DatePickerScreen()
}