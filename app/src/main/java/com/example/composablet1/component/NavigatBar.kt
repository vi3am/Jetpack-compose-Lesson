package com.example.composablet1.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun NavigationScreen() {

    data class NavigatBarIem(
        val id: Int,
        val icon: ImageVector,
        val descriptionContent: String,
        val label: String,
//        val selected : Boolean
    )

    val navigationItems by remember {
        mutableStateOf<List<NavigatBarIem>>(
            listOf(
                NavigatBarIem(
                    id = 1,
                    icon = Icons.Default.Home,
                    label = "Home",
//                    selected = true,
                    descriptionContent = "Home Icon"
                ),
                NavigatBarIem(
                    id = 2,
                    icon = Icons.Default.Search,
                    label = "Search",
//                    selected = true,
                    descriptionContent = "Search Icon"
                ),
                NavigatBarIem(
                    id = 3,
                    icon = Icons.Default.Favorite,
                    label = "Favorites",
//                    selected = false,
                    descriptionContent = "Fav Icon"
                ),
            ),

            )
    }
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(

        bottomBar = {
            NavigationBar() {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                            println("${selectedIndex} ")
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.descriptionContent
                            )
                        },
                        label = {
                            Text(
                                text = item.label
                            )
                        }
                    )
                }
            }
        }
    ) { padding ->

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

@Preview
@Composable
fun NavPreview() {
    NavigationScreen()
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home", fontSize = 24.sp)
    }
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search", fontSize = 24.sp)
    }
}

@Composable
fun Fav(modifier: Modifier =Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Favorite", fontSize = 24.sp)
    }
}