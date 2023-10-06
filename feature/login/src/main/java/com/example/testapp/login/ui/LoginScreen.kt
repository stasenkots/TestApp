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
    val loginViewModel = viewModel<LoginViewModel>(factory = LoginViewModel.Factory())
    val loginState by remember { loginViewModel.loginUiState }
    val login = remember {
        { username: String, password: String ->
            loginViewModel.login(username, password)
        }
    }

    LoginScreen(
        loginState = { loginState },
        login = login,
        onLogIn
    )
}

@Composable
fun LoginScreen(
    loginState: () -> LoginUiState,
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
    loginState: () -> LoginUiState,
    onLogIn: () -> Unit
) {
    when (val loginStateValue = loginState()) {
        is LoginUiState.LoginError -> {
            Toast.makeText(LocalContext.current, loginStateValue.message, Toast.LENGTH_LONG).show()
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
private fun LoginAndPassword(login: (String, String) -> Unit) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    OutlinedTextFieldWithError(
        value = username.value,
        onValueChange = { username.value = it },
        label = { Text(text = stringResource(R.string.username_label)) },
        validate = { it.isEmpty() },
        showError = {
            Text(text = stringResource(R.string.username_non_empty))
        }
    )
    OutlinedTextFieldWithError(
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text(text = stringResource(R.string.password_label)) },
        validate = { it.isEmpty() },
        showError = {
            Text(text = stringResource(R.string.password_non_empty))
        }
    )

    LoginButton(username, password, login)

    Spacer(modifier = Modifier.size(100.dp))


}

@Composable
fun LoginButton(
    username: MutableState<String>,
    password: MutableState<String>,
    login: (String, String) -> Unit
) {
    val isButtonEnabled by remember {
        derivedStateOf { password.value.isNotEmpty() && username.value.isNotEmpty() }
    }

    Button(
        onClick = { login(username.value, password.value) },
        enabled = isButtonEnabled
    ) {
        Text(text = stringResource(R.string.login_label))
    }
}


@Preview
@Composable
fun DefaultPreview() {
    LoginScreen(
        loginState = { LoginUiState.InProgress },
        login = { _, _ -> },
        onLogIn = {}
    )
}
