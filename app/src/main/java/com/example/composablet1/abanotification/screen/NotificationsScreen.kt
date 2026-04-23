package com.example.composablet1.abanotification.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.R
import com.example.composablet1.abanotification.model.AnnouncementsList
import timber.log.Timber
import java.time.format.DateTimeFormatter

@Composable
fun AbaNotification(){
    var selectedIndex by remember{ mutableIntStateOf(0) }
        Scaffold(
            topBar = { AppTopBarABA() },
            containerColor = colorResource(R.color.background),

            ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                //SegmentButton
                SegmentBtn(
                    selectedIndex = selectedIndex,
                    onSelect = { selectedIndex = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                //Conten display of card
                AnimatedContent(
                    targetState = selectedIndex,
                    transitionSpec = {
                        slideInHorizontally(
                            animationSpec = tween(300),
                            initialOffsetX = { it }
                        ) + fadeIn() togetherWith
                                slideOutHorizontally(
                                    animationSpec = tween(200),
                                    targetOffsetX = { -it }
                                ) + fadeOut()
                    },
                    label = "TabSwitchAnimation"
                ) { index ->
                    when (index) {
                        0 -> MyAlerts()
                        1 -> MyAlerts()
                        2 -> AnnouncementsDisplay()
                    }
                }
            }
        }

}


// AppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarABA(){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.outline_arrow_back_ios_24),
                    contentDescription = "arrowLeft",

                    )
            }
        },
        title = {
            Text(
                text = buildAnnotatedString {
                    append("ABA")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Red,
                            fontSize = 24.sp,
                            fontWeight = FontWeight(700)
                        )
                    ) {
                        append("'")

                    }
                    append(" ")
                    append(stringResource(R.string.notification_text)
                        .replaceFirstChar { it.uppercase() })
                },
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )

    )
}



// SegmentButon
@Composable
fun SegmentBtn(selectedIndex: Int, onSelect:(Int)-> Unit){
    val options = remember { mutableListOf("My Alerts","Transactions","Announcements") }
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = colorResource(R.color.background_tint),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        options.forEachIndexed { index, value ->

            SegmentedButton(
//                modifier = Modifier.height(40.dp),
                selected = selectedIndex == index,
                onClick = {
                    onSelect(index)
                    Timber.i("Clicked: $selectedIndex")
                },
//                shape = SegmentedButtonDefaults.itemShape(
//                    index = index,
//                    count = options.size,
//                    baseShape = RoundedCornerShape(16.dp)
//                ),

                shape = SegmentedButtonDefaults.baseShape
                ,
                border =SegmentedButtonDefaults.borderStroke(
                    color = colorResource(R.color.background_tint),
                    width = 1.dp
                )
                ,
                icon = {
                    null
                },
                label = {
                    Text(
                        text=value,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = colorResource(R.color.sencondary),
                    activeContentColor = colorResource(R.color.white),
                    inactiveContainerColor = colorResource(R.color.background_tint),
                    inactiveContentColor = Color.LightGray
                )
            )
        }
    }
}



//Display card of announcements
@Composable
fun AnnouncementsDisplay(){
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
    ) {
        items(AnnouncementsList.size) { index ->
            val announcement = AnnouncementsList[index]
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Text(
                    text = announcement.date.format(
                        DateTimeFormatter.ofPattern("dd MMM yyyy")
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White

                )
                Box(
                    modifier = Modifier.fillMaxWidth().height(160.dp)
                        .padding(vertical = 14.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color.LightGray.copy(0.4f)),
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(announcement.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.8f)
                                    )
                                )
                            )
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .padding(12.dp)
                    ) {
                        Text(
                            text = announcement.title,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700)
                        )
                        Text(
                            text = announcement.subTitle,
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


//Alert Screen
@Composable
fun MyAlerts(){
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "No display yet",
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                color = Color.White.copy(0.7f)
            )
        } }
    }
}




@Preview(showBackground = false)
@Composable
fun ScreenPreview(){
   MyAlerts()
}