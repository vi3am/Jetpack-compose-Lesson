package com.example.composablet1.chipmongbankapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composablet1.R
import com.example.composablet1.chipmongbankapp.model.cardListz
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun NotificationScreen(){
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {AppTopBarT()}
    ) {padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            SegmentBtnT(
                selectedIndex= selectedIndex,
                onSelect = {selectedIndex = it}
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(cardListz.size){ index ->
                    val cardz = cardListz[index]
                    NotificationCard(
                        imageUrl = cardz.imageUrl,
                        title = cardz.title,
                        date = cardz.date,
                        subtitle = cardz.subTitle,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp , vertical = 4.dp)
                    )
                }
            }


        }
    }

}


//AppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarT(){
    TopAppBar(
        title = {
            Text("Notifications")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Arrow back Icon"
                )
            }
        }
    )

}


@Composable
fun SegmentBtnT(selectedIndex: Int, onSelect:(Int) -> Unit){
    val options = remember { mutableListOf("Alerts","Transactions","Announcement") }
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            .background(
                color= colorResource(R.color.bg_segment),
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        options.forEachIndexed { index, value ->
            SegmentedButton(
                modifier = Modifier.padding(horizontal = 5.dp),
                selected = selectedIndex == index,
                onClick = {
                    onSelect(index)
                },
                shape = SegmentedButtonDefaults.baseShape,
                colors = SegmentedButtonDefaults.colors(
                    inactiveContainerColor = colorResource(R.color.bg_segment),
                    inactiveContentColor = Color.Black,
                    activeContainerColor = colorResource(R.color.white),
                    activeContentColor = Color.Black,
                ),
                border = SegmentedButtonDefaults.borderStroke(
                    color = Color.Transparent,
                    width = 1.dp
                ),
                icon = {
                    null
                },
                label = {
                    Text(
                        text = value,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },


            )
        }

    }
}

@Composable
fun NotificationCard(
     imageUrl: String,
     title: String,
     date: LocalDateTime,
     subtitle: String,
    modifier: Modifier
){
    Card(
        modifier = modifier.fillMaxWidth().padding(vertical = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column() {
            AsyncImage(
                model = imageUrl,
                contentDescription = "null",
                modifier = Modifier.fillMaxSize().height(120.dp),
                contentScale = ContentScale.Crop
            )

            //content
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = date.format(
                        DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a")),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}





@Composable
fun NewsCard(
    imageUrl: String,
    title: String,
    date: LocalDate,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            // Image
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            // Content
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                // Title
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Date
//                Text(
//                    text = date,
//                    style = MaterialTheme.typography.labelSmall,
//                    color = Color.Gray
//                )

                Spacer(modifier = Modifier.height(6.dp))

                // Subtitle
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun NotificationPreview(){
    NotificationScreen()
//    PreviewCard()
}