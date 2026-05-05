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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(chipList.size){index ->
                    val chip = chipList[index]
                    FilterChipEx(
                        labelText = chip.labelText
                    )
                }
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                items(chipList.size){i->
                    val chip = chipList[i]
                    InputChipEx(
                        labelText = chip.labelText,
                        onDismiss = {
                            println("Input Clicked")
                        }
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



@Composable
fun FilterChipEx(
    labelText: String
){

    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = {
            selected = !selected
        },
        label = {
            Text(
                text = labelText
            )
        },
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }else null
        }
    )
}

@Composable
fun InputChipEx(
    labelText: String,
    onDismiss: () -> Unit
){
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
    InputChip(
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled},
        label = {
            Text(
                text = labelText
            )
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
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

