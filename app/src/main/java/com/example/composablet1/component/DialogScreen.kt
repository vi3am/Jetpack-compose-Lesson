package com.example.composablet1.component

import android.R.attr.dialogTitle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composablet1.R

@Composable
fun DialogScreen() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.notifications_24),
                    contentDescription = "Example Icon"
                )
            },
            title = {
                Text(text = "dialogTitle")
            },
            text = {
                Text(text = "Hello world")
            },
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {

                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )

    }
    Scaffold(
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    showDialog = true
                }
            ) {
                Text("Open AlertDialog")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }

    }


}

@Preview
@Composable
fun PreviewDialog() {
    DialogScreen()
}