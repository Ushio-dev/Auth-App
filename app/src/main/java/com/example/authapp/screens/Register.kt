package com.example.authapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.authapp.LoginError
import com.example.authapp.components.EmailTextInput
import com.example.authapp.components.PasswordTextInput

@Composable
fun Register(navController: NavHostController) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var repeatedPassword by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(LoginError())
    }

    var errorPassword by remember {
        mutableStateOf(LoginError())
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmailTextInput(email = email, updateEmail = { email = it }, emailError = emailError)
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextInput(
                password = password,
                updatePassword = { password = it },
                errorPassword = errorPassword
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextInput(
                password = repeatedPassword,
                updatePassword = { repeatedPassword = it },
                errorPassword = errorPassword
            )
            Spacer(modifier = Modifier.height(50.dp))
            
        }
    }
}