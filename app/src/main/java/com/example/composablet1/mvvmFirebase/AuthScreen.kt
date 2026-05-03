package com.example.composablet1.mvvmFirebase

import android.R.attr.enabled
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AuthScreen(viewModel: AuthViewModel = viewModel()) {

    val email = viewModel.email
    val password = viewModel.password
    val message = viewModel.message
    val isLoading = viewModel.isLoading

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Firebase Auth", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        val navController = rememberNavController()

        Button(
            onClick = {
                viewModel.login { navController.navigate("FoodsOrderScreen")}
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.register() },

            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        }

        Text(text = message)
    }
}