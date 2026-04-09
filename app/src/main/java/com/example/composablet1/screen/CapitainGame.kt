package com.example.composablet1.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun CapitainGame(){
    var treasureFound by remember { mutableStateOf(0) }
    var direction by remember { mutableStateOf("North") }
    val context = LocalContext.current
    val stormOrTreasure = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TreasureFound : ${treasureFound}")
        Text(text = "Current Direction : ${direction}")
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Button(onClick = {
                direction = "East"
                if(Random.nextBoolean()){
                    treasureFound +=1
                    Toast.makeText(context,"Congregate we're found +1 treasure at ${direction}🎉",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Storm ahead!!🔥",
                        Toast.LENGTH_SHORT).show()
                }
            }){
                Text("Sail East")
            }
            Button(onClick = {
                direction = "South"
                if(Random.nextBoolean()){
                    treasureFound +=1
                    Toast.makeText(context,"Congregate we're found +1 treasure at ${direction}🎉",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Storm ahead!!🔥",
                        Toast.LENGTH_SHORT).show()
                }
            }){
                Text("Sail South")
            }
            Button(onClick = {
                direction = "West"
                if(Random.nextBoolean()){
                    treasureFound +=1
                    Toast.makeText(context,"Congregate we're found +1 treasure at ${direction}🎉",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,"Storm ahead!!🔥",
                        Toast.LENGTH_SHORT).show()
                }
            }){
                Text("Sail West")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview(){
    CapitainGame()
}