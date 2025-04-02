package com.myproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myproyecto.screens.LoginScreen
import com.myproyecto.screens.RegisterScreen
import com.myproyecto.screens.PasswordRecoveryScreen
import com.myproyecto.ui.theme.MyProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProyectoTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginScreen(navController) }
                    composable("register") { RegisterScreen(navController) }
                    composable("password_recovery") { PasswordRecoveryScreen(navController) }
                }
            }
        }
    }
}
