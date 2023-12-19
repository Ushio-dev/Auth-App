package com.example.authapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.authapp.screens.Login
import com.example.authapp.screens.Register

@Composable
fun CustomNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "LOGIN"
    ) {
        composable(route = "LOGIN") {
            Login(navController)
        }
        composable(route = "REGISTER") {
            Register(navController)
        }
    }

}