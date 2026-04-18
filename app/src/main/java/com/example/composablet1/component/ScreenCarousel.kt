package com.example.composablet1.component

import android.R
import android.R.attr.checked
import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.model.cardList
import com.example.composablet1.screen.AppTopBar

@Composable
fun ScreenCarouselEx(){
    Scaffold(
        topBar = { AppTopBar("Carousel Screen") }
    ) {padding ->
        Column(
            modifier = Modifier.padding(padding ).fillMaxSize()
        ) {
            CarouselFunEx()
            CheckBoxEx()
        }

    }
}

//Carousel Card
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselFunEx(){
    val items = remember { cardList }
    HorizontalMultiBrowseCarousel(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        preferredItemWidth = 200.dp,
        itemSpacing = 10.dp,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        state = rememberCarouselState { items.count() },
    ) { i ->
        val item = items[i]
        Image(
            modifier = Modifier.height(200.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            painter = rememberAsyncImagePainter(item.imageUrl),
            contentDescription = "image",
            contentScale = ContentScale.Crop
        )
    }
}



//Checkout Box
@Composable
fun CheckBoxEx(){
    var checked by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight().padding(horizontal = 16.dp)
            .border(1.dp, color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("CheckBox")
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
        }
        Text(
            if(checked) "CheckBox is checked" else "CheckBox is unChecked",
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = false)
@Composable
fun CarouselScreenPre(){
    ScreenCarouselEx()
}