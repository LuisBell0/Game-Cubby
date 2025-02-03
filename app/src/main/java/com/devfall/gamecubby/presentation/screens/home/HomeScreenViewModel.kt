package com.devfall.gamecubby.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class Game(
    val id: Int,
    val name: String = "",
    val playerIds: List<Int> = emptyList(),
)

// TEMPORARY DATA
val game1: Game = Game(id = 1, name="Monopoly", playerIds = listOf(1,2,3))
val game2: Game = Game(id = 2, name="Uno", playerIds = listOf(4,5,6))
val game3: Game = Game(id = 3, name="Jenga", playerIds = listOf(7,8,9))

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