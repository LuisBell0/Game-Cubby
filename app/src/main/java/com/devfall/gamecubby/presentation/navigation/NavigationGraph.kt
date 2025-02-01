package com.devfall.gamecubby.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devfall.gamecubby.presentation.screens.addgame.AddGameScreen
import com.devfall.gamecubby.presentation.screens.home.HomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navigateToAddGameScreen = { navController.navigate(route = Screen.AddGameScreen.route) }
            )
        }
        composable(route = Screen.AddGameScreen.route) {
            AddGameScreen()
        }
    }
}