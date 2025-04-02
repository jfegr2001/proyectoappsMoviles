package com.myproyecto.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myproyecto.components.TextFieldForm

@Composable
fun RegisterScreen(navController: NavController) {
    Scaffold { padding ->
        RegisterForm(padding, onNavigateToLogin = { navController.navigate("login") })
    }
}

@Composable
fun RegisterForm(padding: PaddingValues, onNavigateToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Registro de Usuario", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldForm(
            value = email,
            onValueChange = { email = it },
            label = "Correo Electrónico",
            supportingText = "Ingrese un correo válido",
            onValidate = { it.isEmpty() || !it.contains("@") },
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions.Default
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldForm(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            supportingText = "Debe tener al menos 8 caracteres",
            onValidate = { password.length < 8 },
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions.Default,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldForm(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirmar Contraseña",
            supportingText = "Las contraseñas no coinciden",
            onValidate = { confirmPassword != password },
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions.Default,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            enabled = email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword,
            onClick = { /* TODO: Lógica de registro */ }
        ) {
            Text(text = "Registrarse")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = onNavigateToLogin) {
            Text(text = "¿Ya tienes cuenta? Inicia sesión")
        }
    }
}

