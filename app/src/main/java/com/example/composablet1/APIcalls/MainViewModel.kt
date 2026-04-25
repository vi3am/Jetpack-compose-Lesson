package com.example.composablet1.APIcalls

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


//3. ViewModel (Logic Layer)
class MainViewModel: ViewModel(){
    private val _categoriesState = mutableStateOf(RecipeState())

    val categoriesState : State<RecipeState> = _categoriesState

    init{
        fetchCategories()
    }

    //4. FetchCategories
    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e: Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }


    //5. State Class : memory
    data class RecipeState(
        val loading : Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}