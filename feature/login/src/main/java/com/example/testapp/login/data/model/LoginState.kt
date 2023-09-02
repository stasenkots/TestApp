package com.example.testapp.login.data.model

sealed class LoginUiState {
    object NotLoggined : LoginUiState()
    object InProgress : LoginUiState()
    class Loggined(val userData: UserData) : LoginUiState()
    class ErrorReturned(val message: String) : LoginUiState()
}
