package com.myproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.myproyecto.screens.LoginScreen
import com.myproyecto.screens.PasswordRecoveryScreen
import com.myproyecto.screens.RegisterScreen
import com.myproyecto.user.navegation.HomeScreen
import com.myproyecto.screens.UserReportsScreen
import com.myproyecto.screens.DetailReport.Screen.ReportDetailScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteScreen.HomeScreen
    ) {
        composable<RouteScreen.LoginScreen>{
            LoginScreen(
                navigatToSignUp = {
                    navController.navigate(RouteScreen.RegisterScreen)
                },
                navigaToForgotPassword = {
                    navController.navigate(RouteScreen.PasswordRecoveryScreen)
                },
                navigatetoHome = {
                    navController.navigate(RouteScreen.HomeScreen)
                },
                navigatetoUserReport = {
                    navController.navigate(RouteScreen.UserReportsScreen)
                }
            )
        }
        composable<RouteScreen.RegisterScreen>{
            RegisterScreen()
        }
        composable<RouteScreen.PasswordRecoveryScreen> {
            PasswordRecoveryScreen()
        }
        composable<RouteScreen.HomeScreen> {
            HomeScreen(
                navigateToDetail = {
                    navController.navigate(RouteScreen.ReportDetailScreen(it))
                }
            )
        }
        composable <RouteScreen.UserReportsScreen>{
            UserReportsScreen(

                navigateToDetail = {
                    navController.navigate(RouteScreen.ReportDetailScreen(it))
                }
            )
        }
        composable <RouteScreen.ReportDetailScreen>{

            val args = it.toRoute<RouteScreen.ReportDetailScreen>()

            ReportDetailScreen(
                Id = args.id ,
                onNavigateBack = {
                    navController.popBackStack()
                }

            )
        }



    }
}


