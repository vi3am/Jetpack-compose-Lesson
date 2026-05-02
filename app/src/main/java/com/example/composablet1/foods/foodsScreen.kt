package com.example.composablet1.foods

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composablet1.R


@Composable
fun FoodsOrderScreen(){
    Scaffold(
        topBar = {
            AppBarTOP()
        }
    ) {padding ->
        FoodsScreenLazy(padding)
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarTOP(){
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {},
            ) {
                Icon(
                    modifier = Modifier.background(color = Color.Transparent),
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = null
                )
            }
        },
        title = {
            Text("")
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
fun FoodsScreenLazy(padding: PaddingValues)
{
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding),
    ) {
        item{
            Text(text = "Recipes",
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier.padding(horizontal = 16.dp)
                )
        }
        item {CategoriessMenu("Snakes")}
        item { CategoryCard(foodList1) }
        item {CategoriessMenu("Breakfast")}
        item { CategoryCard(foodList2) }
        item {CategoriessMenu("Lunch")}
        item { CategoryCard(foodList3)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CategoryCard(foodCount : List<FoodsModel>){
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(foodCount){ foodlist ->
            FoodItem(foodList = foodlist)
        }

    }
}

@Composable
fun FoodItem(foodList : FoodsModel){
    Card(
        modifier = Modifier.wrapContentHeight().width(240.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(foodList.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = rememberAsyncImagePainter("https://t4.ftcdn.net/jpg/18/51/88/89/360_F_1851888970_k2ITcveM1b4YiRhhKGewfwAHSLD5pApE.jpg"),   // While loading
                error = rememberAsyncImagePainter("https://linuxize.com/post/php-error-reporting/featured_hu_e9e83299c0d0e8b7.jpg"),               // On failure
                fallback = painterResource(R.drawable.qrcode1),      // If URL is null
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = foodList.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),

            )
            Row(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Text(
                    text = "15 min · Workout",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

            }

        }
    }
}

@Composable
fun CategoriessMenu(text : String){
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp,top = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
        )
        TextButton(onClick = {}) {
            Text("See all")
        }
    }
}

@Preview
@Composable
fun FoodOrderPreview(){
    FoodsOrderScreen()
}