package com.example.authapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login() {
    Scaffold() {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            EmailTextInput()
            PasswordTextInput()
        }
    }
}

@Composable
fun LoginPReview() {
    Login()
}
@Composable
fun EmailTextInput() {
    var isError by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = "",
        onValueChange = {},
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),
        maxLines = 1,
        placeholder = { Text(text = "Email", fontWeight = FontWeight.Bold) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            autoCorrect = true
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Green,
            errorBorderColor = Color.Red
        ),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Debe Ingresar email", color = Color.Red
                )
            }
        }
    )
}

@Composable
fun EmailTextInputPreview() {
    EmailTextInput()
}

@Composable
fun PasswordTextInput() {
    var isVisible by remember {
        mutableStateOf(false)
    }

    var isError by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = "",
        onValueChange = {},
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),
        maxLines = 1,
        placeholder = { Text(text = "Password", fontWeight = FontWeight.Bold) },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            autoCorrect = false
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Green,
            errorBorderColor = Color.Red
        ),
        trailingIcon = {
            if (isVisible) IconButton(
                onClick = {
                    isVisible = !isVisible
                }) {
                Icon(
                    imageVector = Icons.Outlined.Visibility,
                    contentDescription = "visible-password"
                )
            } else {
                IconButton(
                    onClick = {
                        isVisible = !isVisible
                    }) {
                    Icon(
                        imageVector = Icons.Outlined.VisibilityOff,
                        contentDescription = "no-visible-password"
                    )
                }
            }
        },
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Debe Ingresar una contraseña", color = Color.Red
                )
            }
        }
    )
}

@Composable
fun PasswordTextInputPreview() {
    PasswordTextInput()
}