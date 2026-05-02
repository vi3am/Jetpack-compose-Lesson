package com.example.composablet1.ecommerce

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composablet1.R
import com.example.composablet1.component.chipList
import com.google.common.collect.Multimaps.index
import kotlin.math.floor


@Composable
fun EcommerceScreen() {
    val ecomViewModel: EcomViewModel = viewModel()
    val viewState by ecomViewModel.ecommState
    Scaffold(
        topBar = { EcomTopAppBar() },
        containerColor = colorResource(R.color.bgCC)
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .fillMaxSize()
        ) {
            Column {
                // TOP SEARCH ROW
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    EcomSearchBar()

//                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .background(
                                color = colorResource(R.color.bgicon),
                                shape = RoundedCornerShape(20)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_filter_alt_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                AssistChipEcommerce(viewState.list)
//                Spacer(modifier = Modifier.height(8.dp))
            }
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                when {
                    viewState.loading -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    viewState.error != null -> {
                        Text("Error Occured!")
                    }

                    else -> {
                        GridContain(categoriesZ = viewState.list)
                    }
                }
            }


        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcomTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Stylel fashion"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier.background(color = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_notifications_none_24),
//                    painter = painterResource(R.drawable.baseline_notifications_none_24),
                    contentDescription = null
                )
            }
        },
    )
}
@Composable
fun EcomSearchBar() {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        placeholder = { Text("Search...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
//        trailingIcon = {
//            if (query.isNotEmpty()) {
//                IconButton(onClick = { query = "" }) {
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        contentDescription = "Clear"
//                    )
//                }
//            }
//        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color.Gray,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            disabledBorderColor = Color.Gray
        ),

        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(310.dp)
    )
}
@Composable
fun AssistChipEcommerce(categoryz: List<Categoryz>){
    val uniqueCategories = categoryz.distinctBy { it.category.lowercase() }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var selectedIndex by remember { mutableStateOf(0) }
    LazyRow(
            modifier = Modifier.padding(vertical = 8.dp).height(50.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            itemsIndexed(uniqueCategories) { index, item ->
                AssistChipItem(
                    categoryz = item,
                    isSelected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    }
                )
            }
        }
}
@Composable
fun AssistChipItem(
    categoryz: Categoryz,
    isSelected: Boolean,
    onClick: () -> Unit
){

    AssistChip(
        modifier = Modifier.fillMaxHeight().padding(top = 8.dp),
        onClick = onClick,
        label = {
            Text(
                text = categoryz.category.replaceFirstChar{it.uppercase()},
                fontSize = 18.sp,
                fontWeight = FontWeight(500)
            )
        },
        border = null,
//        colors = AssistChipDefaults.assistChipColors(
//            containerColor = colorResource(R.color.bgicon),
//            disabledContainerColor = colorResource(R.color.white),
//            labelColor = colorResource(R.color.white),
//            disabledLabelColor = colorResource(R.color.black),
//
//        ),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = if (isSelected)
                colorResource(R.color.bgicon)
            else
                colorResource(R.color.white),

            labelColor = if (isSelected)
                colorResource(R.color.white)
            else
                colorResource(R.color.black)
        ),
        shape = RoundedCornerShape(40)

    )
}


//Need Improve more
@Composable
fun GridContain(categoriesZ: List<Categoryz>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(top = 16.dp),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(categoriesZ){cate ->
            GridItem(categoryz = cate)
        }
    }
}


@Composable
fun GridItem(categoryz: Categoryz){
    var isClicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.width(180.dp)
            .wrapContentHeight()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
//        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column {
            Box{
                Image(
                    painter = rememberAsyncImagePainter(categoryz.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.Transparent)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Inside
                )
               IconButton(
                   modifier = Modifier.align(Alignment.TopEnd),
                   onClick = {
                       isClicked = !isClicked
                    }
               ) {
                   Icon(
                       imageVector =if(!isClicked) Icons.Default.FavoriteBorder else Icons.Default.Favorite ,
                       contentDescription = null,
                       tint = if(!isClicked) Color.Black.copy(0.8f) else Color.Red.copy(0.8f) ,
                       modifier = Modifier.padding(8.dp)
                           .size(32.dp)
                           .clip(shape = RoundedCornerShape(35))
                           .background(
                               color = Color.White.copy(0.9f))
                   )
               }
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = categoryz.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium

                )
                val rating = floor(categoryz.rating.rate)
                Row {
                    repeat(5) { index ->
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = if (index < rating) colorResource(R.color.oran) else Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Text(
                    text = "$ ${categoryz.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        }
    }
}



@Preview
@Composable
fun EcommerceScreenPre(){
    EcommerceScreen()
}

