package com.example.composablet1.chipmongbankapp.model

import java.time.LocalDate
import java.time.LocalDateTime

data class CardModelz (
    val id: Int,
    val imageUrl : String,
    val title: String,
    val date : LocalDateTime,
    val subTitle: String
)


val cardListz = List(10) { index ->
    CardModelz(
        id = index + 1,
        imageUrl = "https://picsum.photos/300/200?${index + 1}",
        title = "Notification ${index + 1}",
        date = LocalDateTime.now().minusDays(index.toLong()),
        subTitle = "This is subtitle for item ${index + 1}"
    )
}