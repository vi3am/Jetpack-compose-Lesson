package com.example.composablet1.component

import android.R.attr.dialogTitle
import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composablet1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var fullscreenDialog by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val menuItemData = List(10) { "Option ${it + 1}" }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Alert Dialog")
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.notifications_24),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = {
                            expanded = !expanded
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            menuItemData.forEach { text ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = text
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            Icons.Outlined.Person,
                                            contentDescription = null
                                        )
                                    },
                                    trailingIcon = {
                                        Icon(
                                            Icons.AutoMirrored.Outlined.Send,
                                            contentDescription = null
                                        )
                                    },
                                    onClick = {}
                                )
                            }

                        }
                    }

                }
            )
        },

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextButton(
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, Color.LightGray, RectangleShape)
                        .background(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.primary
                        ),
                    onClick = {
                        showDialog = true
                    }
                ) {
                    Text(
                        "AlertDialog",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                TextButton(
                    modifier = Modifier
                        .weight(1f)
                        .border(width = 1.dp, Color.LightGray, RoundedCornerShape(10.dp)),
                    onClick = {
                        fullscreenDialog = true

                    }
                ) {
                    Text("FullScren")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }

    }


    if (fullscreenDialog) {
        Dialog(
            onDismissRequest = {
                fullscreenDialog = false
            },

            ) {
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                shape = RectangleShape,
//
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text("FullScreen Dialog!")
//                    TextButton(
//                        onClick = {
//                            fullscreenDialog =false
//                        }
//                    ) {
//                        Text("Close")
//                    }
//                }
//            }

            Dialog(onDismissRequest = { fullscreenDialog = false }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Text(
                        text = "This is a minimal dialog",
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
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

}


@Preview
@Composable
fun PreviewDialog() {
    DialogScreen()
}