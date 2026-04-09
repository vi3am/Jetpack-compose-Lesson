package com.example.composablet1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun LazyColumnScreen(){
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
     ){ paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                AsyncImage(
                    model = "https://imgs.search.brave.com/CpLIJ7VhuogbiEmb-nOn6sCE0miGW0rR7W_D8BG0QJ4/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/ZnJlZS1waG90by9h/bmltZS1zdHlsZS1j/aGFyYWN0ZXItc3Bh/Y2VfMjMtMjE1MTEz/Mzk5NC5qcGc_c2Vt/dD1haXNfaW5jb21p/bmcmdz03NDAmcT04/MA",
                    contentDescription = "My Image",
                    modifier = Modifier.size(150.dp),
                    onError = {
                        println("Image faild loaded!")
                    }
                )

            }
            item {
                Text("Hello")
            }
            item {
                Text("Hello")
            }
            item {
                Text("Hello")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumPreview(){
    LazyColumnScreen()
}