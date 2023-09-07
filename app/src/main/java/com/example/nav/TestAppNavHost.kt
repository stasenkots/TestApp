package com.example.nav

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.login.ui.LoginScreen

@Composable
fun TestAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Login.route) {
        composable(route = Login.route) {
            LoginScreen(onLogIn = {
                navController.navigate(Home.route)
            })
        }
    }
}
