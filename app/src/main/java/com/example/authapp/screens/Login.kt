package com.example.authapp.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login() {

}

@Composable
fun EmailTextInput() {
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
        isError = false,
        supportingText = {
            if (false) {
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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            autoCorrect = true
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Green,
            errorBorderColor = Color.Red
        ),
        isError = false,
        supportingText = {
            if (false) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Debe Ingresar email", color = Color.Red
                )
            }
        }
    )
}