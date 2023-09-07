package com.example.testapp.login.data.model

sealed class LoginUiState {
    object LogOut : LoginUiState()
    object InProgress : LoginUiState()
    class LogIn(val userData: UserData) : LoginUiState()
    class LoginError(val message: String) : LoginUiState()
}
