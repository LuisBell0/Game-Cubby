package com.devfall.gamecubby.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class Game(
    val id: Int,
    val name: String = "",
    val numberOfPlayers: Int = 0,
)

// TEMPORARY DATA
val game1: Game = Game(id = 1, name="Monopoly", numberOfPlayers = 2)
val game2: Game = Game(id = 2, name="Uno", numberOfPlayers = 4)
val game3: Game = Game(id = 3, name="Jenga", numberOfPlayers = 3)

val gamesList: List<Game> = listOf(game1, game2, game3)

class HomeScreenViewModel : ViewModel() {

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games = _games.asStateFlow()

    init {
        viewModelScope.launch {
            _games.value = gamesList
        }
    }
}