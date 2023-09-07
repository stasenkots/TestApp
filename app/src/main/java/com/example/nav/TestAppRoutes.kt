package com.example.nav

sealed class Route(val route: String)

object Login: Route("login")
object Home: Route("home")

