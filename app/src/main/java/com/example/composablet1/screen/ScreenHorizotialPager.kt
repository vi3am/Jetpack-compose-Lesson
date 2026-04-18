package com.example.composablet1.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composablet1.R


@Composable
fun ScreenHorizPager(){
    val pagerState = rememberPagerState(pageCount = {3})
    val interactionSource = remember { MutableInteractionSource() }
    Scaffold(
        topBar = {AppTopBar("KB PRASAC Bank")},
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.cardBackground))
    ) { padding ->
        HorizontalPager(
            modifier = Modifier.padding(padding),
            state = pagerState,
            contentPadding = PaddingValues(24.dp),
            pageSpacing = 16.dp
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = colorResource(R.color.white)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ){
                    // account name
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(R.color.oran))
                    ) {
                        Text(
                            text = "Jonh Alex ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            modifier = Modifier.
                            padding(start = 16.dp , top = 8.dp, bottom = 8.dp)
                        )
                    }
                    // Balance section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(2f).height(80.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Savings Account",
                                    fontSize = 10.sp,
                                    color = Color.DarkGray.copy(0.8f)
                                    )
                                VerticalDivider(color = MaterialTheme.colorScheme.secondary)
                                Text("002 225 214 003",
                                    fontSize = 10.sp,
                                    color = Color.DarkGray.copy(0.8f)
                                )
                            }
                            Row() {
                                Text("200,45",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight(700)

                                    )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "USD",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color.Black.copy(0.4f)
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(R.drawable.eyeshide),
                                contentDescription = "eyehide",
                                tint = colorResource(R.color.oran)
                            )
                            Image(
                                modifier = Modifier.size(40.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .alpha(0.8f),
                                painter = painterResource(R.drawable.qrcode1),
                                contentDescription = "eyehide",
                            )
                        }

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxHeight()
                                .weight(1f)
                                .clip(shape = RectangleShape)
                                .border(1.dp, color = Color.LightGray),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ElevatedButton(
                                onClick = {},
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = colorResource(R.color.white)
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_swap_horizontal_circle_24),
                                    contentDescription = "icon",
                                    tint = colorResource(R.color.oran)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Transfers")
                            }

                        }
                        Row(
                            modifier = Modifier.fillMaxHeight()
                                .clickable(onClick = {
                                    println("clicked")
                                },
                                    interactionSource = interactionSource,
                                    indication = LocalIndication.current
                                )
                                .weight(1f)
                                .clip(shape = RectangleShape)
                                .border(1.dp, color = Color.LightGray),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ElevatedButton(
                                onClick = {},
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = colorResource(R.color.white)
                                )
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.receipt_long_24),
                                    contentDescription = "icon",
                                    tint = colorResource(R.color.oran)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Payment")
                            }
                        }
                    }

                }
            }
        }


    }

}



@Preview(showBackground = true)
@Composable
fun ScreenHorizPagerPreview(){
    ScreenHorizPager()
}