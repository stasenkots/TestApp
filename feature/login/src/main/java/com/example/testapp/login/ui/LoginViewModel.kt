package com.example.testapp.login.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.network.di.NetworkDepsProvider
import com.example.testapp.login.data.LoginRepository
import com.example.testapp.login.data.model.LoginResult
import com.example.testapp.login.data.model.LoginUiState
import com.example.testapp.login.di.DaggerLoginComponent
import com.example.testapp.login.di.LoginComponent
import kotlinx.coroutines.launch

internal class LoginViewModel(
    private val component: LoginComponent,
    private val loginRepository: LoginRepository = component.repository
) : ViewModel() {

    val loginUiState: MutableState<LoginUiState> = mutableStateOf(LoginUiState.NotLoggined)

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val loginResult = loginRepository.login(username, password)
            when(loginResult) {
                is LoginResult.Success -> loginUiState.value = LoginUiState.Loggined(loginResult.value)
                is LoginResult.Error -> loginUiState.value = LoginUiState.ErrorReturned(loginResult.reason)
            }
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val loginComponent = DaggerLoginComponent.builder()
                .loginApi(NetworkDepsProvider.loginApi)
                .build()
            return LoginViewModel(loginComponent) as T
        }
    }
}
