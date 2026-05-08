package com.example.composablet1.appRoom.data

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val shortType: ShortType = ShortType.FIRST_NAME
)
