package com.myproyecto.screens.DetailReport.componentsReportDetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(Id: String , onNavigateBack: () -> Unit) {

    CenterAlignedTopAppBar(
        title = {
            Text(text = "Reporte #$Id")
        },
        actions = {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = Icons.Default.Verified,
                contentDescription = "Estado"
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onNavigateBack

            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null
                )
            }

        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.Black
        )

    )
}