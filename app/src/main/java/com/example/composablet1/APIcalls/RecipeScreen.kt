package com.example.composablet1.APIcalls

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


//6. UI Layer RecipeScreen (Main Screen)
@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier
){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
    Scaffold() {padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding)
        ){
            // 7. UI Logic
            when{
                viewState.loading ->{
                    CircularProgressIndicator(modifier.align(Alignment.Center))
                }
                viewState.error != null ->{
                    Text("ERROR OCCURRED")
                }
                else ->{
                    CategoryScreen(categories = viewState.list)
                }
            }
        }
    }
}

// 8. GridScreen
@Composable
fun CategoryScreen(categories : List<Category>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(categories){ category ->
            CategoryItem(category = category)
        }
    }
}


// 9 . data of category item how it displays
@Composable
fun CategoryItem(category: Category){
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
        )
    }
}

@Preview
@Composable
fun RecipeScreenPre(){
    RecipeScreen()
}