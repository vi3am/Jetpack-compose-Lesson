package com.example.composablet1.abanotification.model

import java.time.LocalDate
import kotlin.String

data class AnnouncementsModel(
    val id: Int,
    val date: LocalDate,
    val imageUrl: String,
    val title: String,
    val subTitle: String,
)

val AnnouncementsList = listOf(
    AnnouncementsModel(
        id = 1,
        date = LocalDate.of(2026,2,2),
        imageUrl = "https://4kwallpapers.com/images/walls/thumbs/8965.png",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA bank"
    ),
    AnnouncementsModel(
        id = 2,
        date = LocalDate.of(2026,4,14),
        imageUrl = "https://wallpapers.com/images/hd/1080p-anime-denji-chainsaw-man-4zd16sc3gf6ihg0i.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),
    AnnouncementsModel(
        id = 3,
        date = LocalDate.now(),
        imageUrl = "https://wallpapers.com/images/hd/chainsaw-man-pictures-7ytkmk14c2pahuj7.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),
    AnnouncementsModel(
        id = 4,
        date = LocalDate.of(2026,2,2),
        imageUrl = "https://wallpapers.com/images/hd/chainsaw-man-pictures-a4rldj9en8uobfuz.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),
    AnnouncementsModel(
        id = 1,
        date = LocalDate.of(2026,2,2),
        imageUrl = "https://4kwallpapers.com/images/walls/thumbs/8965.png",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA bank"
    ),
    AnnouncementsModel(
        id = 2,
        date = LocalDate.of(2026,4,14),
        imageUrl = "https://wallpapers.com/images/hd/1080p-anime-denji-chainsaw-man-4zd16sc3gf6ihg0i.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),
    AnnouncementsModel(
        id = 3,
        date = LocalDate.now(),
        imageUrl = "https://wallpapers.com/images/hd/chainsaw-man-pictures-7ytkmk14c2pahuj7.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),
    AnnouncementsModel(
        id = 4,
        date = LocalDate.of(2026,2,2),
        imageUrl = "https://wallpapers.com/images/hd/chainsaw-man-pictures-a4rldj9en8uobfuz.jpg",
        title = "Sending you our best wishes",
        subTitle = "Happy khmer new from all of us at ABA banks"
    ),

)