package com.myproyecto.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Espacio reservado para Google Maps
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Mapa aquí")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("generate_report") }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Generar Reporte")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Generar Reporte")
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    TextField(
        value = query,
        onValueChange = { query = it },
        label = { Text("Buscar...") },
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}
