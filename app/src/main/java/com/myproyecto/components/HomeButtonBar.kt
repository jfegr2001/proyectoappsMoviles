package com.myproyecto.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeButtonBar() {
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"

                )
            },
            selected = false,
            onClick = { /*TODO*/ },
            label = {
                Text(
                    text = "Home"
                )
            }


        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Generar Reporte"

                )
            },
            selected = false,
            onClick = { /*TODO*/ },
            label = {
                Text(
                    text = "Generar Reporte"
                )
            }

        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Mi Reportes"

                )
            },
            selected = false,
            onClick = { /*TODO*/ },
            label = {
                Text(
                    text = "MI Reportes"
                )
            }

        )
    }
}
