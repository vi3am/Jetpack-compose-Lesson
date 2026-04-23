package com.example.composablet1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.component.ChipScreen
import com.example.composablet1.component.ScreanBadgeBox
import com.example.composablet1.component.ScreenCarouselEx
import com.example.composablet1.component.ScreenTopAppbar
import com.example.composablet1.component.SeggmentScreen
import com.example.composablet1.screen.BoxScreen
import com.example.composablet1.screen.LazyVertcalGridScreen
import com.example.composablet1.screen.ScreenHorizPager
import com.example.composablet1.screen.ScreenLazyHoriz
import com.example.composablet1.screen.TestingLayoutPreview
import com.example.composablet1.ui.theme.ComposableT1Theme
import com.example.composablet1.abanotification.screen.AbaNotification
import com.example.composablet1.chipmongbankapp.screen.NotificationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            ScreenHorizPager()
//            ScreenCarouselEx()
//            ChipScreen()
//            ScreanBadgeBox()
//            SeggmentScreen()
//            AbaNotification()
            NotificationScreen()
        }
    }
}



@Composable
fun SimpleUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, Jetpack Compose!",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            println("Button Clicked!")
        }) {
            Text("Click Me")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Test(){
    Column(

    ) {
        for (i in 1..10){
            Text(
                text = "Hello ${i}",
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    Test()
//    CapitainGame()
    MainActivity()

}
