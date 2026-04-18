package com.example.composablet1.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composablet1.R

@Composable
fun ScreenTestingLayout(){
    Scaffold(
        modifier = Modifier.navigationBarsPadding()

    ) {padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().height(100.dp).padding(16.dp)
                    .border(
                        2.dp,
                        color = Color.LightGray
                    ),
                horizontalArrangement = Arrangement.Center,
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxHeight().width(50.dp).weight(1f).clip(shape = CircleShape),
                    model = "https://wallpapers.com/images/hd/chainsaw-man-background-tlhq64gbw9vznqps.jpg",
                    contentDescription = "image Url",
//                    placeholder = painterResource(R.drawable.l),
                    contentScale = ContentScale.Crop,
                    onError = {
                        println("Image faild loaded!")
                    }

                )
                Column(
                    modifier = Modifier.fillMaxHeight().weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Alex jesohn",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600)

                        )
                    Text("3 minutes ago")
                }
            }
        }

    }

}



@Preview(showBackground = false)
@Composable
fun TestingLayoutPreview(){
    ScreenTestingLayout()
}