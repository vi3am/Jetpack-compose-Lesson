package com.example.composablet1.screen

import android.util.Log.i
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.R
import com.example.composablet1.model.cardList

@Composable
fun ScreenLazyHoriz(){
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = { AppTopBar("LazyHorz") }

        ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
        ){
            Text(
                text = "HorizontalGrid",
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
                )
//            HorizontalDivider()
            LazyHorizontalGrid(
                modifier = Modifier.height(300.dp).fillMaxWidth().padding(top = 16.dp)
                    ,
                rows = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
               items(cardList.size){ index->
                   val card = cardList[index]
                   Row(
                       modifier = Modifier.width(400.dp)
                           .fillMaxWidth().padding(horizontal = 16.dp)
                           .clip(shape = RoundedCornerShape(16.dp))
                           .background(color = MaterialTheme.colorScheme.primary.copy(0.2f))
                           .border(2.dp,Color.LightGray),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.SpaceBetween,

                   ){
                       Row(modifier = Modifier.width(200.dp).fillMaxSize(),
                           horizontalArrangement = Arrangement.SpaceBetween,
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Image(
                               painter = rememberAsyncImagePainter(card.imageUrl),
                               contentDescription = "",
                               contentScale = ContentScale.Crop,
                               modifier = Modifier.fillMaxHeight().weight(1.2f)
                           )
                           Spacer(modifier = Modifier.width(8.dp))
                           Column(
                               modifier = Modifier.fillMaxHeight().weight(0.8f),
                               verticalArrangement = Arrangement.Center
                           ) {
                               Text("Header")
                               Text("description...")
                           }
                       }
                       IconButton(
                           onClick = {}
                       ) {
                           Icon(
                               imageVector = Icons.Filled.MoreVert,
                               contentDescription = "Icon"
                           )
                       }
                   }
               }
            }
            VerticalGridScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview(){
    ScreenLazyHoriz()
}