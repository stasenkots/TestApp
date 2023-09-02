package com.example.testapp.login.data.model

sealed class LoginResult {
    class Success(val value: UserData) : LoginResult()
    class Error(val reason: String) : LoginResult()
}
