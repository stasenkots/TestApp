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
import com.example.login.R
import com.example.testapp.login.data.model.LoginResult
import com.example.testapp.login.data.model.LoginUiState
import com.example.testapp.ui.components.OutlinedTextFieldWithError

@Composable
fun LoginScreen() {
    val loginViewModel: LoginViewModel = viewModel(factory = LoginViewModel.Factory)
    val loginState by remember { loginViewModel.loginUiState }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.size(100.dp))
        LoginAndPassword(loginViewModel)
        when (loginState) {
            is LoginUiState.ErrorReturned -> {
                val message = (loginState as LoginUiState.ErrorReturned).message
                Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()
            }
            is LoginUiState.Loggined -> {
                val userData = (loginState as LoginUiState.Loggined).userData
                Toast.makeText(LocalContext.current, userData.toString(), Toast.LENGTH_LONG).show()
            }
            is LoginUiState.NotLoggined -> {}
            is LoginUiState.InProgress -> {
                CircularProgressIndicator(
                    modifier = Modifier.width(20.dp),
                )
            }
        }

    }

}

@Composable
private fun LoginAndPassword(loginViewModel: LoginViewModel){
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
        onClick = { loginViewModel.login(username, password) },
        enabled = password.isNotEmpty() && username.isNotEmpty()
    ) {
        Text(text = stringResource(R.string.login_label))
    }
}


@Preview
@Composable
fun DefaultPreview() {
    LoginScreen()
}
