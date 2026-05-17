package com.example.composablet1.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerScreen() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(0.dp)
            ) {
                DrawerContent(selectedIndex = selectedIndex, onSelectedChange = {
                    selectedIndex = it
                }, drawerState)
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Navigation Drawer")
                    },
//                    modifier = TODO(),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = null
                            )
                        }
                    },
                )
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
            ) {
                item {
                    when (selectedIndex) {
                        0 -> {
                            Home(modifier = Modifier.padding(padding))
                        }

                        1 -> {
                            Search(modifier = Modifier.padding(padding))
                        }

                        2 -> {
                            Fav(modifier = Modifier.padding(padding))
                        }
                    }
                }
            }

        }
    }

}


@Composable
fun DrawerContent(selectedIndex: Int, onSelectedChange: (Int) -> Unit, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Column(
        //scroll without using lazy column
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        UserNav()
        listDrawer.forEachIndexed { index, item ->
            NavigationDrawerItem(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent,
                    selectedContainerColor = Color.Transparent,

                    ),
                label = {
                    Text(
                        text = item.label,
                        fontWeight = FontWeight(400),
                        fontSize = 18.sp
                    )
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                selected = selectedIndex == index,
                onClick = {
                    onSelectedChange(index)
                    scope.launch {
                        drawerState.close()
                    }
                    println(index)
                    println(selectedIndex)
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    Color.LightGray.copy(0.6f),
                    RoundedCornerShape(10.dp)
                ),
            onClick = {}
        ) {
            Text(
                "Log out",
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
        }


    }
}


@Composable
fun UserNav() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .dropShadow(
                    shape = RoundedCornerShape(16.dp),
                    shadow = Shadow(
                        radius = 4.dp,
                        color = Color(0x40000000),
//                            offset = DpOffset(x = 1.dp, 1.dp)
                    )
                )
                .align(Alignment.Center)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://i.pinimg.com/736x/97/39/9a/97399ae4762f2840a54954c6c0e66698.jpg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.LightGray, CircleShape),
                    )
                    Text(
                        "User Profile",
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Icon"
                        )
                    }
                }
                HorizontalDivider()
                Row(
//                        modifier = Modifier.padding(.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = null
                        )
                    }
                    Text("Create Facebook Page")
                }
            }
        }

    }

}


data class DrawItem(
    val icon: ImageVector,
    val label: String
)

val listDrawer = listOf<DrawItem>(
    DrawItem(
        icon = Icons.Outlined.Person,
        label = "Person"
    ),
    DrawItem(
        icon = Icons.Outlined.Home,
        label = "Home"
    ),

    DrawItem(
        icon = Icons.Outlined.Settings,
        label = "Settings"
    ),

    DrawItem(
        icon = Icons.Outlined.Favorite,
        label = "Favorite"
    ),
    DrawItem(
        icon = Icons.Outlined.Notifications,
        label = "Notifications"
    ),

    DrawItem(
        icon = Icons.Outlined.Email,
        label = "Messages"
    )
)

@Preview
@Composable
fun PreviewDrawer() {
    NavigationDrawerScreen()
}