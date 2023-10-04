package com.example.testapp.login.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.di.LocalStorageComponentProvider
import com.example.network.di.NetworkComponentProvider
import com.example.testapp.login.data.LoginRepository
import com.example.testapp.login.data.model.LoginResult
import com.example.testapp.login.data.model.LoginUiState
import com.example.testapp.login.di.DaggerLoginComponent
import com.example.testapp.login.di.LoginComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class LoginViewModel(
    private val component: LoginComponent,
    private val loginRepository: LoginRepository = component.repository
) : ViewModel() {

    private val _loginUiState: MutableState<LoginUiState> = mutableStateOf(LoginUiState.LogOut)
    val loginUiState: State<LoginUiState> = _loginUiState

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val loginResult = loginRepository.login(username, password)
            when(loginResult) {
                is LoginResult.Success -> _loginUiState.value = LoginUiState.LogIn(loginResult.value)
                is LoginResult.Error -> _loginUiState.value = LoginUiState.LoginError(loginResult.reason)
            }
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val loginComponent = DaggerLoginComponent.builder()
                .loginApi(NetworkComponentProvider.loginApi)
                .userProtoStore(LocalStorageComponentProvider.userProtoStore)
                .build()
            return LoginViewModel(loginComponent) as T
        }
    }
}
