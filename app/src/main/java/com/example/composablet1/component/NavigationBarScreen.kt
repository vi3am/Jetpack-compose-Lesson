package com.example.composablet1.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("home", "home", Icons.Outlined.Home, "HomeScreenIcon"),
    ADD("add", "add", Icons.Default.AddCircle, "AddScreenIcon"),
    PROFILE("profile", "profile", Icons.Outlined.Person, "ProfileScreenIcon")
}

//@Composable
//fun AppNavHost(
//    navController: NavHostController,
//    startDestination: Destination
//) {
//    Destination.entries.forEach { destination ->
//        composable(destination.route) {
//            when (destination) {
//                Destination.HOME -> {
//                    HomeScreenT()
//                }
//
//                Destination.ADD -> {
//                    AddScreen()
//                }
//            }
//        }
//    }
//}

@Composable
fun HomeScreenT() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")
    }
}

@Composable
fun AddScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Add Screen"
        )
    }

}

@Composable
fun ProfileAV() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Profile Screen"
        )
    }
}


@Composable
fun NavigationBarScreen() {
    val navController = rememberNavController()

    val items = listOf(
        Destination.HOME,
        Destination.ADD,
        Destination.PROFILE
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo("home")
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(item.icon, contentDescription = item.contentDescription)
                        },
                        label = {
                            Text(item.label)
                        }
                    )
                }
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Destination.HOME.route,
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreenT() }
            composable("add") { AddScreen() }
            composable("profile") { ProfileAV() }
        }
    }
}


@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBarScreen()
}