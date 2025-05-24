package com.myproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.myproyecto.screens.LoginScreen
import com.myproyecto.screens.PasswordRecoveryScreen
import com.myproyecto.screens.RegisterScreen
import com.myproyecto.screens.HomeScreen


@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteScreen.LoginScreen
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
            HomeScreen()
        }
    }
}


