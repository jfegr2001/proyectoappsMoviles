package com.myproyecto.screens
import android.util.Patterns

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

import com.myproyecto.components.BackgroundImage
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navigatToSignUp: () -> Unit ,
    navigaToForgotPassword: () -> Unit,
    navigatetoHome: () -> Unit
) {
    Scaffold { padding ->
        val navController = rememberNavController()
        LoginForm(
            padding = padding,
            onLoginAsAdmin = { navController.navigate("user_reports") } ,
            navigatToSignUp = {
                navigatToSignUp()

            },
            navigatToForgotPassword = {
                navigaToForgotPassword()
            },

            navigatetoHome = {
                navigatetoHome()
            }


        )
    }
}

@Composable
fun LoginForm(
    padding: PaddingValues,
    onLoginAsAdmin: () -> Unit,
    navigatToSignUp :() -> Unit,
    navigatToForgotPassword :() -> Unit,
    navigatetoHome :() -> Unit

) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
       BackgroundImage()

        // Contenido del formulario
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text (
                text = "Bienvenido\n" +
                        "Iniciar Sesión",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    showError = false
                },
                label = { Text("Correo electrónico", color = Color.Black) },
                isError = email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches(),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.LightGray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black                 )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    showError = false
                },
                label = { Text("Contraseña", color = Color.Black) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                isError = password.isNotEmpty() && password.length < 8,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.LightGray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            if (showError) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Usuario o contraseña incorrectos",
                    color = Color.Red
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    when {
                        email == "admin" && password == "admin" -> {
                            onLoginAsAdmin()
                        }
                        email == "apps@gmail.com" && password == "123" -> {
                            navigatetoHome()
                        }
                        else -> {
                            showError = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth(),
                enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Usuario", tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Ingresar", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick ={
                    navigatToSignUp()
                }

            ) {

                Text("¿No tienes cuenta? Regístrate", color = Color.Black)
            }

            TextButton(
                onClick = {

                    navigatToForgotPassword()
                }
            ) {
                Text("¿Olvidaste tu contraseña?", color = Color.Black)
            }
        }
    }
}