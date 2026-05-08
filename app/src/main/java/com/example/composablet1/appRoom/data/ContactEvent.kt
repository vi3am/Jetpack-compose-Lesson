package com.example.composablet1.appRoom.data

sealed interface ContactEvent {
    object saveContact: ContactEvent
    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val lastName: String): ContactEvent
    data class SetPhoneNumber(val phoneNumber: String): ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent
    data class SortContact(val shortType: ShortType): ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
}