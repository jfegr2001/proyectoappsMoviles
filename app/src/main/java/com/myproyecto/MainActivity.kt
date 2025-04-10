package com.myproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myproyecto.screens.EditUserScreen
import com.myproyecto.screens.EmergencyMenuScreen
import com.myproyecto.screens.GenerateReportScreen
import com.myproyecto.screens.HomeScreen
import com.myproyecto.screens.LoginScreen
import com.myproyecto.screens.MyReportDetailScreen
import com.myproyecto.screens.RegisterScreen
import com.myproyecto.screens.PasswordRecoveryScreen
import com.myproyecto.screens.UserReportsScreen
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
                    composable("home") { HomeScreen(navController) }
                    composable("generate_report/{categoria}") { backStackEntry ->
                        val categoria = backStackEntry.arguments?.getString("categoria") ?: "Sin categoría"
                        GenerateReportScreen(navController, loggedInUser = "admin", categoriaSeleccionada = categoria)
                    }
                    composable("edit_user") { EditUserScreen(navController, loggedInUser = "admin") }
                    composable("emergency_menu") { EmergencyMenuScreen(navController) }
                    composable("user_reports") {
                        UserReportsScreen(navController)
                    }
                    composable("my_report_detail") {
                        MyReportDetailScreen(navController)
                    }


                }
                }
            }
        }
    }

