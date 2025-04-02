package com.myproyecto.screens

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.myproyecto.components.TextFieldForm

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold { padding ->
        LoginForm(
            padding = padding,
            onNavigateToRegister = { navController.navigate("register") },
            onNavigateToRecovery = { navController.navigate("password_recovery") }
        )
    }
}

@Composable
fun LoginForm(
    padding: PaddingValues,
    onNavigateToRegister: () -> Unit,
    onNavigateToRecovery: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextFieldForm(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            supportingText = "El email no es válido",
            onValidate = { !Patterns.EMAIL_ADDRESS.matcher(it).matches() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldForm(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            supportingText = "Debe tener al menos 8 caracteres",
            onValidate = { password.length < 8 },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isPassword = true
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            enabled = email.isNotEmpty() && password.isNotEmpty(),
            onClick = { /* TODO: Lógica de login */ }
        ) {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "Usuario")
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onNavigateToRegister) {
            Text(text = "Registrarse")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(onClick = onNavigateToRecovery) {
            Text(text = "¿Olvidaste tu contraseña?")
        }
    }
}
