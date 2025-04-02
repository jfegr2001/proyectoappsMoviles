package com.myproyecto.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun TextFieldForm(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    supportingText: String,
    label: String,
    onValidate: (String) -> Boolean,
    keyboardOptions: KeyboardOptions,
    isPassword: Boolean = false

) {
    var isError by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        singleLine = true,
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = supportingText)
            }
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(text = label) },
        onValueChange = {
            onValueChange(it)
            isError = onValidate(it)
        }
    )
}
