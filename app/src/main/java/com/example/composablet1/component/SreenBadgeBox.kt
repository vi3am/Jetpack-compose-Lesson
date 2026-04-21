package com.example.composablet1.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composablet1.R
import com.google.android.gms.common.SignInButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreanBadgeBox(){

    var newNotification by remember{ mutableStateOf(true) }
    var countBadge by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar ={
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Badge Box Screen"
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            countBadge = 0
                    }) {
                        BadgedBox(
                            badge = {
                               if (newNotification){
                                   Badge(
                                       containerColor = Color.Red,
                                       contentColor = Color.White
                                   ){
                                       Text(
                                           text = "$countBadge"
                                       )
                                   }
                               }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.notifications_24),
                                contentDescription = "notification"
                            )
                        }
                    }
//                    IconButton(onClick = {
//                        newNotification = false
//                    }) {
//                        BadgedBox(
//                            badge = {
//                                Badge()
//                            }
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.notifications_24),
//                                contentDescription = "notification"
//                            )
//                        }
//                    }
                },
                colors =  TopAppBarDefaults.centerAlignedTopAppBarColors(
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            )
        },
        bottomBar = {
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    countBadge++
                }
            ) {
                Text(
                    text = "Clicked..!"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick={
                if(countBadge >= 1) countBadge-- else println("Can't")
            }) {
                Text("-", fontSize = 32.sp)
            }
        }

    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                //FilledTonalButton
                FilledTonalButton(
                    onClick = {},

                ) {
                    Text("FilledTonalBtn")
                }

                //Icon button
                IconButton(
                    modifier = Modifier
                        .background(
                            color = Color.LightGray,
                            shape = CircleShape
                        ),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    ),
                    onClick = {},
                    ) {
                    BadgedBox(
                        badge = {
                            if (newNotification){
                                Badge(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                ){
                                    Text(
                                        text = "$countBadge"
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.notifications_24),
                            contentDescription = "notification"
                        )
                    }
                }

                //Text Button
                TextButton(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(16.dp)),
                    onClick = {}) {
                    Text(
                        text = "Text btn",
                        color = Color.White
                        )
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                //ElevatedButton
                ElevatedButton(
                    onClick= {},
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 16.dp
                    )
                    ) {
                    Text("Button")
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "arrow icon"
                    )
                }

                FilledIconButton(onClick ={} ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "arrow icon"
                    )
                }

                //Filled Button
                Button(onClick = {}) {
                    Row(
                        modifier = Modifier.wrapContentSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Filled Button")
                    }
                }

                //ToggleButton
                var isChecked by remember { mutableStateOf(false) }
                FilledIconToggleButton(
                    checked = isChecked,
                    onCheckedChange = { value ->
                        isChecked = value
                    }
                ) {
                    if(isChecked){
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = ""
                        )
                    }
                }
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("Cancel")
            }

        }

    }

}

@Preview(showBackground = false)
@Composable
fun BadgeBoxPreview(){
    ScreanBadgeBox()
}