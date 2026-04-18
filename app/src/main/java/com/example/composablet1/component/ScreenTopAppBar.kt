package com.example.composablet1.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablet1.R

@Composable
fun ScreenTopAppbar() {
    val showDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBarz(showDialog)
        }
    ) { paddding ->
        Column(
            modifier = Modifier.padding(paddding)
        ) {
            AlertDialogEx(
                show = showDialog.value,
                nDismiss ={
                    showDialog.value = false
                }
            )
        }

    }
}


//TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarz(showDialog: MutableState<Boolean>) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = {
                showDialog.value = true
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription =  null
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "notification"
                )
            }
           IconButton(
               onClick = {}
           ) {
               Icon(
                   imageVector = Icons.Default.MoreVert,
                   contentDescription = null
               )
           }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(0.8f),
            actionIconContentColor = colorResource(R.color.white),
            titleContentColor = colorResource(R.color.white),
            navigationIconContentColor = colorResource(R.color.white)
        ),
    )
}


//AlertDialog component
@Composable
fun AlertDialogEx(show: Boolean,nDismiss:() -> Unit){

    if(show){
        AlertDialog(
            title = {
                Text(
                    text = "សួស្ដី",
                )
            },
            onDismissRequest = nDismiss,
            confirmButton = {
                TextButton(
                    onClick = {
                        println("confirm clicked")
                    }
                ) {
                    Text("confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = nDismiss) {
                    Text("Cancel")
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null
                )
            },
            text = {
                Text("Hello everyone i love you so mcuh")
            },
            shape = RoundedCornerShape(8.dp),
            containerColor = MaterialTheme.colorScheme.background,
            iconContentColor = colorResource(R.color.purple_500),
            titleContentColor = colorResource(R.color.black),
            textContentColor = colorResource(R.color.purple_200),
            tonalElevation = 2.dp,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ScreenTopAppbar()
}
