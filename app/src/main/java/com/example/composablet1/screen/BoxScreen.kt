package com.example.composablet1.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerpadding->
        Box(
            modifier =
                Modifier.padding(innerpadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Box(Modifier.fillMaxSize().background(Color.Cyan))
            Box(
                Modifier.matchParentSize().padding(top = 20.dp, bottom = 20.dp).background(Color.Yellow)
            )
            Box(Modifier.matchParentSize().padding(40.dp).background(Color.Magenta))
            Box(Modifier.align(Alignment.Center).size(300.dp).background(Color.Cyan, shape = RoundedCornerShape(68.dp,0.dp,68.dp,0.dp)))
            Box(Modifier.align((Alignment.TopStart)).size(150.dp).padding(16.dp).background(Color.Red, shape = RoundedCornerShape(16.dp)))
            Box(Modifier.align(Alignment.BottomEnd).size(100.dp).background(Color.DarkGray, shape = CircleShape))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun BoxScreenPreview(){
    BoxScreen()
}