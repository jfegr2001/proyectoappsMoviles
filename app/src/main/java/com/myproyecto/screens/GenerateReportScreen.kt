package com.myproyecto.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenerateReportScreen(navController: NavController, loggedInUser: String) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var isImportant by remember { mutableStateOf(false) }
    val currentDateTime: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
    val location = "Ubicación automática" // TODO: Integrar API de ubicación

    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Generar Reporte") },
                actions = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menú de usuario")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Editar información") },
                            onClick = {
                                expanded = false
                                // TODO: Navegar a la pantalla de edición de información
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Home") },
                            onClick = {
                                expanded = false
                                navController.navigate("home")
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Cerrar sesión") },
                            onClick = {
                                expanded = false
                                navController.navigate("login")
                            }
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título del Reporte") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción del Reporte") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp), // Altura aumentada para el campo de descripción
                maxLines = 5
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = imageUrl,
                onValueChange = { imageUrl = it },
                label = { Text("URL de la Imagen") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isImportant,
                    onCheckedChange = { isImportant = it }
                )
                Text("Marcar como Importante")
            }
            Spacer(modifier = Modifier.height(20.dp))

            Text("Fecha: $currentDateTime")
            Text("Ubicación: $location")
            Text("Usuario: $loggedInUser")
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /* TODO: Guardar reporte */ }) {
                Text("Generar Reporte")
            }
        }
    }
}

