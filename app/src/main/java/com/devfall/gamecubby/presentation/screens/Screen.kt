package com.devfall.gamecubby.presentation.screens

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddGameScreen: Screen("add_game_screen")
}