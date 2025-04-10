package com.myproyecto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReportDetailScreen(navController: NavController) {
    val titulo = "Fuga de Agua"
    val descripcion = "Se detectó una fuga de agua en la calle 10 con carrera 15. Necesita atención urgente."
    val categoria = "Infraestructura"
    val fecha = "2025-04-10 11:45:00"
    val ubicacion = "Calle 10 #15-25"
    val imagenUrl = "https://images.unsplash.com/photo-1581092918326-4b8b4a644b5c"
    val esImportante = true

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Reporte") }
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            color = Color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Categoría: $categoria",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )

                if (esImportante) {
                    Text(
                        text = " Importante",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = descripcion,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Fecha: $fecha", color = Color.Black)
                Text("Ubicación: $ubicacion", color = Color.Black)

                Spacer(modifier = Modifier.height(16.dp))



                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF91C788))
                ) {
                    Text("Volver", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


