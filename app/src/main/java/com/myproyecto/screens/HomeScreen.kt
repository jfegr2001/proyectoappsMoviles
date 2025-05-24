package com.myproyecto.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.myproyecto.components.HomeButtonBar

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
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

            HomeButtonBar()

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

