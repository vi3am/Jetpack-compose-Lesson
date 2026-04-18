package com.example.composablet1.screen

import android.R.attr.contentDescription
import android.graphics.drawable.Icon
import androidx.annotation.ColorLong
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.R
import com.example.composablet1.model.CardModel
import com.example.composablet1.model.cardList


@Composable
fun LazyRowScreen(){
    Scaffold(
        containerColor = Color.White,
        topBar = { AppTopBar("LazyRowScreen") }
    ) {padding->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            item { CardSection("Title Section") }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String){
    CenterAlignedTopAppBar(
        title = {
           Row(
               modifier = Modifier.fillMaxHeight(),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(
                   painter = painterResource(R.drawable.prasac_icon),
                   contentDescription = "prasac",
                   modifier = Modifier.size(30.dp),
                   colorFilter = ColorFilter.tint(colorResource(R.color.oran)),
                   contentScale = ContentScale.Crop
               )
               Spacer(modifier = Modifier.width(8.dp))
               Text(
                   text = title.uppercase(), color = Color.White,
                   fontSize = 20.sp
               )
           }
        },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "default icon"
                )
            }
        },
        actions = {
            IconButton(onClick = {},
                modifier = Modifier.padding(8.dp)
            ) {
                BadgedBox(
                    badge = {
                        Badge(
                            modifier = Modifier.clip(shape = CircleShape),
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text(
                                "99+",
                                fontSize = 8.sp)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Action icon",
                        tint = colorResource(R.color.oran)

                    )
                }
            }
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = colorResource(R.color.bgAppbar),
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        )

    )
}
@Composable
private fun CardSection(title: String){
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp),
        text = title,
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth().background(color = Color.Transparent),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(cardList){card ->
            Card(
                modifier = Modifier
                    .width(150.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp) // shadow/elevation
            ) {
                Box{
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(Color.White.copy(alpha = 0.15f))
                            .blur(16.dp)
                    )
                    Column() {
                        Image(
                            painter = rememberAsyncImagePainter(card.imageUrl),
                            contentDescription = "Example image",
                            modifier = Modifier.fillMaxWidth().height(90.dp).clip(shape = RoundedCornerShape(16.dp,16.dp)),
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

@Preview(showBackground = true)
@Composable
fun LazyRowPreview(){
    LazyRowScreen()
}


