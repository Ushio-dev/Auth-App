package com.example.authapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authapp.LoginError
import com.example.authapp.ui.theme.Purple40

@Composable
fun PasswordTextInput(
    password: String,
    updatePassword: (String) -> Unit,
    errorPassword: LoginError
) {
    var isVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = password,
        onValueChange = updatePassword,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 17.sp,
        ),
        maxLines = 1,
        //placeholder = { Text(text = "Password", color = Color.Black) },
        label = { Text(text = "Password", color = Color.Black) },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            autoCorrect = false
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            errorBorderColor = Color.Red,
            unfocusedBorderColor = Purple40
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
        isError = errorPassword.isError,
        supportingText = {
            if (errorPassword.isError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = errorPassword.message,
                    color = Color.Red
                )
            }
        },
        shape = RoundedCornerShape(25)
    )
}
