package com.myproyecto.navigation

import kotlinx.serialization.Serializable

sealed class RouteScreen {

    @Serializable
    data object  HomeScreen : RouteScreen()

    @Serializable
    data object  LoginScreen : RouteScreen()

    @Serializable
    data object  RegisterScreen : RouteScreen()

    @Serializable
    data object  PasswordRecoveryScreen : RouteScreen()

    @Serializable
    data object  GenerateReportScreen : RouteScreen()

    @Serializable
    data object  EditUserScreen : RouteScreen()

    @Serializable
    data object  EmergencyMenuScreen : RouteScreen()

    @Serializable
    data object  UserReportsScreen : RouteScreen()

    @Serializable
    data object  MyReportDetailScreen : RouteScreen()





}