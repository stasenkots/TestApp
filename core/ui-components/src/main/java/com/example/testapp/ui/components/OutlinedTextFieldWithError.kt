package com.example.testapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.input.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldWithError(
    value: String,
    onValueChange: ((String) -> Unit),
    label: @Composable (() -> Unit)? = null,
    validate: (String) -> Boolean,
    showError: @Composable (() -> Unit)
) {

    var isError by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isError = validate(it)
        },
        label = label,
        isError = isError,
        supportingText = {
            if (isError) {
                showError()
            }
        }
    )
}

