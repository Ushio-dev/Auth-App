package com.example.authapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authapp.LoginError
import com.example.authapp.ui.theme.Purple40

@Composable
fun EmailTextInput(email: String, updateEmail: (String) -> Unit, emailError: LoginError) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = email,
        onValueChange = updateEmail,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 17.sp,
            textAlign = TextAlign.Start,
        ),
        maxLines = 1,
        //placeholder = { Text(text = "Email", color = Color.Black) },
        label = {
            Text(
                text = "Email",
                color = Color.Black
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            autoCorrect = true
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            errorBorderColor = Color.Red,
            unfocusedBorderColor = Purple40,
        ),
        isError = emailError.isError,
        supportingText = {
            if (emailError.isError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = emailError.message, color = Color.Red
                )
            }
        },
        shape = RoundedCornerShape(25)
    )
}