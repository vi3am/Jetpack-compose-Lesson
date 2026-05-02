package com.example.composablet1.ecommerce

import com.google.gson.annotations.SerializedName


data class Rating(
    val rate: Double,
    val count: Int
)
data class Categoryz(
    val id: Int,
    val title: String,
    val price : Double,
    val description: String,
    val category: String,
    @SerializedName("image") val imageUrl: String,
    val rating: Rating
)

data class CategoriesResponseZ(val categoriesZ: List<Categoryz>)