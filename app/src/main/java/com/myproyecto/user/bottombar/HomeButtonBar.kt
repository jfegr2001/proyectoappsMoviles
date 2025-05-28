package com.myproyecto.user.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.TableRows
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.TableRows
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.myproyecto.user.navegation.RouteUserTab
import androidx.compose.runtime.getValue
@Composable
fun HomeButtonBar(

    navController: NavHostController


) {
    var lista = listOf<NavigationBarUser>(
        NavigationBarUser(
            title = "Home",
            route = RouteUserTab.Home,
            icon = Icons.Outlined.Home,
            inconSelected = Icons.Filled.Home
        ),

        NavigationBarUser(
            title = "Generar Reporte",
            route = RouteUserTab.GenerateReport,
            icon = Icons.Outlined.AddCircle,
            inconSelected = Icons.Filled.AddCircle
        ),
        NavigationBarUser(
            title = "Mi Reportes",
            route = RouteUserTab.Reports,
            icon = Icons.Outlined.AccountBox,
            inconSelected = Icons.Filled.AccountBox
        )
    )
    NavigationBar {
        NavigationBarItem(
            icon = {

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"

                )
            },
            selected = false,
            onClick = {

                navController.navigate(RouteUserTab.Home)

            },
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
            onClick = {

                navController.navigate(RouteUserTab.GenerateReport)

            },
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
            onClick = {
                navController.navigate(RouteUserTab.Reports)
            },
            label = {
                Text(
                    text = "MI Reportes"
                )
            }

        )
    }

    NavigationBar {

        val navBackStackEntry  by navController.currentBackStackEntryAsState()
        val cureenDestination  = navBackStackEntry ?.destination

        lista.forEach {

            val isSelected = cureenDestination?.route == it.route::class.qualifiedName


            NavigationBarItem(

                label = {
                    Text(
                        text = it.title
                    )
                },

                onClick = {
                    navController.navigate(it.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true

                        }
                        launchSingleTop = true
                        restoreState = true

                    }

                },
                icon = {
                    if (isSelected){

                        Icon(
                            imageVector = it.inconSelected,
                            contentDescription = "Icono de  ${it.title}"
                        )
                    }else {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = "Icono de  ${it.title}"
                        )

                    }

                },
                selected = isSelected

            )

        }
    }

}

data class NavigationBarUser(
    val route: RouteUserTab,
    val icon: ImageVector,
    val inconSelected: ImageVector,
    val title: String
)




