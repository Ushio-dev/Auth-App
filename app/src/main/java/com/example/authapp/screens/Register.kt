package com.example.authapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Register(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Texto()
        Spacer(modifier = Modifier.height(15.dp))
        // Pasar controller por parametros, pasando la funcion que haga el trabajo de navegacion no funciona, nose porque
        BackButton(navController)
    }
}

@Composable
fun Texto() {
    Text(text = "Hola Mundo")
}

@Composable
fun BackButton(navController: NavHostController) {
    Button(onClick = { navController.navigate("LOGIN") }) {
        Text(text = "Volver a Login")
    }
}

