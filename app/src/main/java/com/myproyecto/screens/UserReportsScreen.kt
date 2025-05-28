package com.myproyecto.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myproyecto.components.BackgroundImage
import com.myproyecto.model.Report
import androidx.compose.ui.Alignment
import com.myproyecto.model.Location
import com.myproyecto.model.ReportState
import java.time.LocalDateTime
import androidx.compose.foundation.lazy.items
import coil.compose.AsyncImage
import androidx.compose.ui.text.font.FontWeight
import com.myproyecto.components.TransparentTopBar


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun UserReportsScreen(
    navigateToDetail: (String) -> Unit
) {
    // Lista de reportes vacía como placeholder (puedes poblarla desde ViewModel o repositorio)
    val lista = listOf<Report>(
            Report(
                id = "101",
                title = "Accidente de tránsito en Av. Central",
                description = "Colisión entre dos vehículos. Presencia de patrullas.",
                state = ReportState.ACCEPTED,
                image = listOf("https://images.unsplash.com/photo-1602071791644-008d4ccbea56?auto=format&fit=crop&w=800&q=80"),
                location = Location(19.4326, -99.1332), // CDMX
                fecha = LocalDateTime.now()
            ),
    Report(
        id = "102",
        title = "Incendio en edificio residencial",
        description = "Fuego en el tercer piso. Se evacuó a los residentes. Bomberos en el lugar.",
        state = ReportState.PENDING,
        image = listOf("https://images.unsplash.com/photo-1609602710584-2c4e0e8e30d5?auto=format&fit=crop&w=800&q=80"),
        location = Location(40.7128, -74.0060), // Nueva York
        fecha = LocalDateTime.now().minusHours(3)
    ),
    Report(
        id = "103",
        title = "Árbol caído bloqueando calle",
        description = "Tras una tormenta, un árbol cayó sobre la calle 5. No hay paso vehicular.",
        state = ReportState.PENDING,
        image = listOf("https://images.unsplash.com/photo-1600359755798-b4c81e6a0e9a?auto=format&fit=crop&w=800&q=80"),
        location = Location(34.0522, -118.2437), // Los Ángeles
        fecha = LocalDateTime.now().minusDays(1)
    )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()

        Scaffold(
            topBar = {
                TransparentTopBar("Mis reportes")

            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(lista) { report ->
                    ReporCard(
                        report = report,
                        navigateToDetail = navigateToDetail
                    )
                }
            }
        }
    }
}

@Composable
fun ReporCard(report: Report,
              navigateToDetail: (String) -> Unit = {}

) {

    OutlinedCard (

        onClick = {

            navigateToDetail(report.id)
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)

    ) {

        Row (

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            AsyncImage(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                model = report.image[0],
                contentDescription = "Imagen del reporte",

                )
            Column (
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {

                Text(
                    fontWeight = FontWeight.Bold,
                    text = report.title,

                )
                Text(
                    text = report.description,

                )
            }
        }




    }

}


