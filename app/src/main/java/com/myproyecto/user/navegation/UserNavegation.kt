package com.myproyecto.user.navegation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myproyecto.screens.generateReport.screen.GenerateReportScreen
import com.myproyecto.user.tabs.HomeScreenUserTab
import com.myproyecto.user.tabs.MyReportsScreenTab

@Composable
fun UserNavigation(

    paddingValues: PaddingValues,
    navController: NavHostController,
    navgitatToDetail : (String) -> Unit
) {

    NavHost(
        modifier = Modifier
            .padding(paddingValues),
        navController = navController,
        startDestination = RouteUserTab.Home
    ) {
        composable<RouteUserTab.Home> {
            HomeScreenUserTab(
                onNavigateToDetail = navgitatToDetail
            )
        }
        composable<RouteUserTab.Reports> {

            MyReportsScreenTab (
                navigateToDetail = navgitatToDetail
            )
        }
        composable<RouteUserTab.GenerateReport> {

            GenerateReportScreen(
                navController = TODO(),
                loggedInUser = TODO(),
                categoriaSeleccionada = TODO()
            )


        }

    }
}