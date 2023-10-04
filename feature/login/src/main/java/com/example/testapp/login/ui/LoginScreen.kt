package com.example.testapp.login.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test.R
import com.example.testapp.login.data.model.LoginUiState
import com.example.testapp.ui.components.OutlinedTextFieldWithError

@Composable
fun LoginScreen(
    onLogIn: () -> Unit
) {
    val loginViewModel: LoginViewModel = viewModel(factory = LoginViewModel.Factory())
    val loginState by loginViewModel.loginUiState

    LoginScreen(
        loginState = loginState,
        login = loginViewModel::login,
        onLogIn
    )
}

@Composable
fun LoginScreen(
    loginState: LoginUiState,
    login: (String, String) -> Unit,
    onLogIn: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.size(100.dp))
        LoginAndPassword(login)
        LoginResult(loginState, onLogIn)
    }
}

@Composable
fun LoginResult(
    loginState: LoginUiState,
    onLogIn: () -> Unit
){
    when (loginState) {
        is LoginUiState.LoginError -> {
            Toast.makeText(LocalContext.current, loginState.message, Toast.LENGTH_LONG).show()
        }
        is LoginUiState.LogIn -> {
            onLogIn()
        }
        is LoginUiState.LogOut -> {}
        is LoginUiState.InProgress -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(80.dp)
                    .padding(horizontal = 60.dp),
            )
        }
    }
}

@Composable
private fun LoginAndPassword(login: (String, String) -> Unit){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    OutlinedTextFieldWithError(
        value = username,
        onValueChange = { username = it },
        label = { Text(text = stringResource(R.string.username_label)) },
        validate = { it.isEmpty() },
        showError = {
            Text(text = stringResource(R.string.username_non_empty))
        }
    )
    OutlinedTextFieldWithError(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = stringResource(R.string.password_label)) },
        validate = { it.isEmpty() },
        showError = {
            Text(text = stringResource(R.string.password_non_empty))
        }
    )

    Spacer(modifier = Modifier.size(100.dp))

    Button(
        onClick = { login(username, password) },
        enabled = password.isNotEmpty() && username.isNotEmpty()
    ) {
        Text(text = stringResource(R.string.login_label))
    }
}


@Preview
@Composable
fun DefaultPreview() {
    LoginScreen(
        loginState = LoginUiState.InProgress,
        login = {_, _ -> },
        onLogIn = {}
    )
}
