package com.example.authapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private var _errorState: MutableStateFlow<LoginError> = MutableStateFlow(LoginError())

    val errorStateFlow: StateFlow<LoginError>
        get() = _errorState

    fun checkPassword(password: String) {
        if (password.isEmpty()) {

            _errorState.value.isError = true
            _errorState.value.message = "Ingrese contraseña"
        }
/*
        if (password.length < 8) {
            _errorState.value.isError = true
            _errorState.value.message = "La contraseña debe poseer 8 o mas caracteres"
        }

 */
    }
}