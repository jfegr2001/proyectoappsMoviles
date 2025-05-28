package com.myproyecto.user.navegation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.myproyecto.user.bottombar.HomeButtonBar


@Composable
fun HomeScreen(

    navigateToDetail: (String) -> Unit
) {
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            HomeButtonBar(
                navController =  navController
            ) }
    ){ paddingValues ->

        UserNavigation(
            paddingValues = paddingValues,
            navController = navController ,
            navgitatToDetail =  navigateToDetail
        )


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


