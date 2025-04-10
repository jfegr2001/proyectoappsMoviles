package com.myproyecto.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EmergencyMenuScreen(navController: NavController) {
    val categorias = listOf(
        "Seguridad",
        "Emergencia Médica",
        "Infraestructura",
        "Mascotas",
        "Comunidad"
    )

    var categoriaSeleccionada by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = Color(0xFFF0F0F0),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Menú de Reporte de Emergencias",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Selecciona una categoría",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            categorias.forEach { categoria ->
                val isActive = categoria == categoriaSeleccionada
                Button(
                    onClick = {
                        categoriaSeleccionada = if (isActive) null else categoria
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isActive) Color(0xFF91C788) else Color.LightGray
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(categoria)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    categoriaSeleccionada?.let {
                        navController.navigate("generate_report/$it")
                    }
                },
                enabled = categoriaSeleccionada != null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (categoriaSeleccionada != null) Color(0xFF91C788) else Color.Gray
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Generar Reporte", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("user_reports") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91C788)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Reportes Ciudadanos", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("my_report_detail") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91C788)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Mis Reportes", fontWeight = FontWeight.Bold)
            }

        }
    }
}
