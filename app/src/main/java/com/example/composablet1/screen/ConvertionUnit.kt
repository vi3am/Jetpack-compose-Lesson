package com.example.composablet1.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnity by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oconversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnit(): Unit{
        // ?; elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull()?: 0.0
        val inputFactor = when(inputUnit) {
            "Centimeter" -> 0.01
            "Meters" -> 1.0
            "Feet" -> 0.3048
            "Millimeters" -> 0.001
            else -> 1.0
        }

        val outputFactor = when(outputUnity) {
            "Centimeter" -> 0.01
            "Meters" -> 1.0
            "Feet" -> 0.3048
            "Millimeters" -> 0.001
            else -> 1.0
        }
        val result =  (inputValueDouble * inputFactor / outputFactor)
//        val result = (inputValueDouble * conversionFactor.value * 100 / oconversionFactor.value) /100
        outputValue = result.toString()
    }
    Column(
        modifier = Modifier.padding(top = 24.dp).background(MaterialTheme.colorScheme
            .background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Unit Converter", color =  Color.Black, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnit()
            },
            label = {Text("Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var context = LocalContext.current
            Box{
                Button(
                    onClick = {
                        iExpanded = true
//                        Toast.makeText(context,"Button Clicked", Toast.LENGTH_SHORT).show()
                    }){
                    val result = inputUnit?: "Select"
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                    DropdownMenu(expanded = iExpanded, onDismissRequest = {iExpanded = false}) {
                        DropdownMenuItem(text = {Text("Centimeter")}, onClick = {
                            inputUnit = "Centimeter"
                            conversionFactor.value = 0.01
                            convertUnit()
                            iExpanded = false
                        })
                        DropdownMenuItem(text = {Text("Meters")}, onClick = {
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnit()
                            iExpanded = false
                        })
                        DropdownMenuItem(text = {Text("Feet")}, onClick = {
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnit()
                            iExpanded = false
                        })
                        DropdownMenuItem(text = {Text("Millimeters")}, onClick = {
                            inputUnit = "Millimeters"
                            conversionFactor.value = 0.001
                            convertUnit()
                            iExpanded = false
                        })
                    }
                }
            }
//            Spacer(modifier = Modifier.width(16.dp))
            //output
            Box{
                Button(
                    onClick = {
                        oExpanded = true
//                        Toast.makeText(context,"Button Clicked", Toast.LENGTH_SHORT).show()
                    }){
                    Text(text = outputUnity)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {oExpanded = false}) {
                    DropdownMenuItem(text = {Text("Centimeter")}, onClick = {
                        outputUnity = "Centimeter"
                        oconversionFactor.value = 0.01
                        convertUnit()
                        oExpanded = false
                    })
                    DropdownMenuItem(text = {Text("Meters")}, onClick = {
                        outputUnity = "Meters"
                        oconversionFactor.value = 1.00
                        convertUnit()
                        oExpanded = false
                    })
                    DropdownMenuItem(text = {Text("Feet")}, onClick = {
                        outputUnity = "Feet"
                        oconversionFactor.value = 0.3048
                        convertUnit()
                        oExpanded = false
                    })
                    DropdownMenuItem(text = {Text("Millimeters")}, onClick = {
                        outputUnity = "Millimeters"
                        oconversionFactor.value = 0.001
                        convertUnit()
                        oExpanded = false
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Result: $outputValue $outputUnity",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPre(){
    UnitConverter()
}