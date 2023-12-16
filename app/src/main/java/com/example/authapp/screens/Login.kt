package com.example.authapp.screens

import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authapp.LoginError
import com.example.authapp.R
import com.example.authapp.ui.theme.Purple40

@Composable
fun Login() {
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorEmailState by remember {
        mutableStateOf(LoginError())
    }
    var errorPasswordState by remember {
        mutableStateOf(LoginError())
    }

    Scaffold(
        modifier = Modifier.paint(
            painterResource(id = R.drawable.auth_),
            contentScale = ContentScale.FillBounds
        ),
        containerColor = Color.Transparent
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            EmailTextInput(
                email = email,
                updateEmail = { newEmail ->
                    email = newEmail
                },
                emailError = errorEmailState
            )
            PasswordTextInput(
                password = password,
                updatePassword = {
                    password = it
                    Log.d("ERROR PASSWORD", errorPasswordState.message)
                },
                errorPassword = errorPasswordState
            )
            Spacer(modifier = Modifier.height(32.dp))
            SignInButton(isPasswordWrong = {
                if (password.isEmpty() && email.isEmpty()) {
                    /*
                    In jetpack Compose for recomposition to be triggered the State/MutableState
                    should have new value and composition gets triggered in the scope State/MutableState is read only.
                     */
                    errorPasswordState = LoginError(true, "Ingrese contraseña")
                    errorEmailState = LoginError(true, "Ingrese email")

                } else {
                    if (password.length < 8) {
                        errorPasswordState =
                            LoginError(true, "La contraseña debe tener al menos 8 caracteres")
                    }
                }

            })
            Spacer(modifier = Modifier.height(50.dp))
            AlternativeSignIn()
        }
    }
}

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

@Composable
fun SignInButton(isPasswordWrong: () -> Unit) {
    ElevatedButton(
        modifier = Modifier.width(250.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(Purple40.value)
        ),
        onClick = {
            isPasswordWrong()
        }) {
        Text(text = "Ingresar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}

private fun checkValidPassword(password: String): Boolean {
    //TODO verificar porque se espera a que escriba algo ,cuando doy al boton, para mostrar el error
    return password.isEmpty()
}


@Composable
fun AlternativeSignIn() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        Arrangement.SpaceEvenly,
        Alignment.CenterVertically
    ) {
        GoogleSignIn()
        FacebookSignIn()
    }
}

@Composable
fun GoogleSignIn() {
    Box(
        modifier = Modifier
            .clickable {
                Log.d("CLICK", "Logeando con Google")
            }
            .height(55.dp),
    ) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            painter = painterResource(id = R.drawable.google_login),
            contentDescription = "google-signin"
        )
    }
}

@Composable
fun FacebookSignIn() {
    Box(modifier = Modifier
        .clickable {
            Log.d("CLICK", "Logeando con Facebook")
        }
        .background(Color.Transparent)
        .height(55.dp)) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            painter = painterResource(id = R.drawable.facebook_social_media_social_icon),
            contentDescription = "google-signin"
        )
    }
}
