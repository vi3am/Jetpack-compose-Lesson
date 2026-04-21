package com.example.composablet1.component

import android.R.attr.text
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composablet1.screen.AppTopBar

@Composable
fun SeggmentScreen(){

    var selecedOption = remember { mutableStateListOf(false,false,false) }
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day","Month","Year")
    Scaffold(
        topBar = {
            AppTopBar("Seggment")
        }
    ) {padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                text = "1. SingleChoiceSegmented".uppercase(),
                fontSize = 16.sp)
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                options.forEachIndexed { index, value ->
                    SegmentedButton(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            Log.d("Seggment","Selected : $selectedIndex")
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),
//                        colors = SegmentedButtonDefaults.colors(),
                        label = {
                            Text(text = value)
                        },
                    )
                }
            }
            Text(
                modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                text = "2. MultipleChoiceSegmented".uppercase(),
                fontSize = 16.sp)
            MultiChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                options.forEachIndexed { index, value ->
                    SegmentedButton(
                        checked = selecedOption[index],
                        onCheckedChange = { isChcecked ->
                            selecedOption[index] = isChcecked
                            Log.d("Multiple","checked: ${selecedOption[index]}")
                        },
                        label = {
                            Text(text = value)
                        },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),
                    )
                }
            }
        }
    }

}

@Preview(showBackground = false)
@Composable
fun SeggmentScreenPreview(){
    SeggmentScreen()
}