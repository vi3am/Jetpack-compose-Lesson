package com.example.composablet1.mvvmFirebase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val repo = AuthRepository()

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun login() {

        if (email.isBlank() || password.isBlank()) {
            message = "Email and Password cannot be empty ❌"
            return
        }

        isLoading = true
        repo.login(email, password) { success, error ->
            isLoading = false
            message = if (success) "Login Success ✅" else error ?: "Error"
        }
    }

    fun register() {

        if (email.isBlank() || password.isBlank()) {
            message = "Email and Password cannot be empty ❌"
            return
        }

        if (password.length < 6) {
            message = "Password must be at least 6 characters"
            return
        }

        isLoading = true
        repo.register(email, password) { success, error ->
            isLoading = false
            message = if (success) "Register Success ✅" else error ?: "Error"
        }
    }
}