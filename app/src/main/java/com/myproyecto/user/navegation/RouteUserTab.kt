package com.myproyecto.user.navegation

import kotlinx.serialization.Serializable

sealed class RouteUserTab {

    @Serializable
    object Home : RouteUserTab()

    @Serializable
    object Reports : RouteUserTab()

    @Serializable
    object Profile : RouteUserTab()

    @Serializable
    object GenerateReport : RouteUserTab()



}