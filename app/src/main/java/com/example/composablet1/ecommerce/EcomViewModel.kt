package com.example.composablet1.ecommerce

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EcomViewModel : ViewModel(){


    //Create variable of state
    private val _ecommerceState = mutableStateOf(EcommState())
    val ecommState: State<EcommState> = _ecommerceState

    init {
        fechEcommerce()
    }

    //fetching data
    private fun fechEcommerce(){
        viewModelScope.launch {
            try {
                val response = recipeServicez.getCategoriesz()
                _ecommerceState.value = _ecommerceState.value.copy(
                    list = response,
                    loading = false,
                    error = null

                )
            }catch (e: Exception){
                _ecommerceState.value = _ecommerceState.value.copy(
                    loading = false,
                    error = "Error fetching data product: ${e.message}"
                )
            }
        }
    }

    //Declear state
    data class EcommState(
        val loading: Boolean = true,
        val list: List<Categoryz> = emptyList(),
        val error: String? = null
    )
}
