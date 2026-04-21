package com.example.composablet1.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablet1.screen.AppTopBar

@Composable
fun ChipScreen(){
    Scaffold(
        topBar = { AppTopBar("ChipScreen") }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(chipList.size){index ->
                    val chip = chipList[index]
                    AssistChipEx(
                        leadIcon = chip.leadIcon,
                        labelText = chip.labelText,
                        trailIcon = chip.trailIcon
                    )
                }
            }
        }
    }
}

@Composable
fun AssistChipEx(
    leadIcon: ImageVector,
    labelText: String,
    trailIcon: ImageVector
){

    AssistChip(
        onClick = {
            Log.d("AssistChip","Hello world")
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(AssistChipDefaults.IconSize),
                imageVector = leadIcon,
                contentDescription = "setting icon"
            )
        },
        label = { Text(labelText) },
        trailingIcon = {
            Icon(
                imageVector = trailIcon,
                contentDescription = "close iccon"
            )
        }

    )
}

@Preview(showBackground = false)
@Composable
fun PreviewFun(){
    ChipScreen()
}



data class ChipModel(
    val leadIcon: ImageVector,
    val labelText: String,
    val trailIcon: ImageVector
)

val chipList = listOf(
    ChipModel(
        leadIcon = Icons.Filled.Build,
        labelText = "AssistChip",
        trailIcon = Icons.Filled.Close
    ),
    ChipModel(
        leadIcon = Icons.Filled.Menu,
        labelText = "Menu",
        trailIcon = Icons.Filled.Close
    ),
    ChipModel(
        leadIcon = Icons.Filled.Call,
        labelText = "Jake chip",
        trailIcon = Icons.Filled.Close
    ),
    ChipModel(
        leadIcon = Icons.Filled.Check,
        labelText = "Check",
        trailIcon = Icons.Filled.Close
    ),

)

