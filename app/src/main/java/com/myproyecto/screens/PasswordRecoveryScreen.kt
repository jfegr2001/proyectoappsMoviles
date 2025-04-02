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
fun PasswordRecoveryScreen(navController: NavController) {
    Scaffold { padding ->
        PasswordRecoveryForm(padding, onNavigateBack = { navController.navigate("login") })
    }
}

@Composable
fun PasswordRecoveryForm(padding: PaddingValues, onNavigateBack: () -> Unit) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Recuperación de Contraseña", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldForm(
            value = email,
            onValueChange = { email = it },
            label = "Correo Electrónico",
            supportingText = "Ingrese su correo para recibir instrucciones",
            onValidate = { it.isEmpty() || !it.contains("@") },
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions.Default
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { /* TODO: Implementar recuperación */ }) {
            Text(text = "Enviar Instrucciones")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { onNavigateBack() }) {
            Text(text = "Volver al Login")
        }
    }
}


