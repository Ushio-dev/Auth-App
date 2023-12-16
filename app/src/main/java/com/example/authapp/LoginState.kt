package com.example.authapp

sealed class LoginState {
    class Error(var message: String) : LoginState()
}