package com.devfall.gamecubby.presentation.screens.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class Game(
    val name: String = "",
    val numberOfPlayers: Int = 0,
)

// TEMPORARY DATA
val game1: Game = Game(name="Monopoly", numberOfPlayers = 2)
val game2: Game = Game(name="Uno", numberOfPlayers = 4)
val game3: Game = Game(name="Jenga", numberOfPlayers = 3)

val gamesList: List<Game> = listOf(game1, game2, game3)

class HomeScreenViewModel : ViewModel() {

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games = _games.asStateFlow()

    // Simulate API call
    fun fetchGames() {
        viewModelScope.launch {
            _games.value = gamesList
        }
    }
}