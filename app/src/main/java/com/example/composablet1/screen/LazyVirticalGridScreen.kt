package com.example.composablet1.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.model.cardList

@Composable
fun LazyVertcalGridScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {AppTopBar()}
    ) {padding ->
        Text(text = "Title section", fontSize = 24.sp)
        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
            columns = GridCells.Adaptive(minSize = 120.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            items(cardList.size){index ->
                var card = cardList[index]
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(6.dp) // shadow/elevation
                ) {
                    Box{
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(Color.White.copy(alpha = 0.05f))
                                .blur(16.dp)
                        )
                        Column() {
                            Image(
                                painter = rememberAsyncImagePainter(card.imageUrl),
                                contentDescription = "Example image",
                                modifier = Modifier.fillMaxWidth().height(110.dp).clip(shape = RoundedCornerShape(16.dp,16.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = card.label,
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                    ,modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = Icons.Filled.FavoriteBorder,
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Black
                                )
                            }

                        }

                    }
                }
//
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun LazyVertcalGridPreview(){
    LazyVertcalGridScreen()
}