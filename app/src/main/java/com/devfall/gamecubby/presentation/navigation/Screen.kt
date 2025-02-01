package com.devfall.gamecubby.presentation.navigation

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object AddGameScreen: Screen("add_game_screen")
}