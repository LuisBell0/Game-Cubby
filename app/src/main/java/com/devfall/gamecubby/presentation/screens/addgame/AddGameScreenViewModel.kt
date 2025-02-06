package com.devfall.gamecubby.presentation.screens.addgame

import androidx.lifecycle.ViewModel
import com.devfall.gamecubby.domain.models.Game
import com.devfall.gamecubby.domain.models.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class AddGameScreenViewModel : ViewModel() {

    private val _game = MutableStateFlow(
        Game(
            id = 0,
            name = "",
            comments = "",
            images = emptyList(),
            players = listOf(Player(id = 0))
        )
    )
    val game = _game.asStateFlow()

    fun updateGameName(name: String) {
        _game.update {
            it.copy(
                name = name
            )
        }
    }

    fun updateGameComments(comments: String) {
        _game.update {
            it.copy(
                comments = comments
            )
        }
    }

    fun addGameImage(image: String) {
        _game.update {
            it.copy(
                images = it.images + image
            )
        }
    }

    fun removeGameImage(imageIndex: Int) {
        _game.update {
            val imagesMut = it.images.toMutableList()
            imagesMut.removeAt(imageIndex)
            it.copy(
                images = imagesMut
            )
        }
    }

    fun addPlayer() {
        _game.update {
            if (_game.value.players.isEmpty()) {
                it.copy(
                    players = listOf(Player(id = 0))
                )
            }
            else {
                it.copy(
                    players = it.players + Player(id = it.players.last().id + 1)
                )
            }
        }
    }

    fun removePlayer(playerIndex: Int) {
        _game.update {
            val playersMut = it.players.toMutableList()
            playersMut.removeAt(playerIndex)
            it.copy(
                players = playersMut.mapIndexed { index, player ->
                    player.copy(id = index)
                }
            )
        }
    }

    fun updatePlayerName(playerIndex: Int, name: String) {
        _game.update {
            val playersMut = it.players.toMutableList()
            playersMut[playerIndex] = playersMut[playerIndex].copy(name = name)
            it.copy(
                players = playersMut
            )
        }
    }

    fun updatePlayerComments(playerIndex: Int, comments: String) {
        _game.update {
            val playersMut = it.players.toMutableList()
            playersMut[playerIndex] = playersMut[playerIndex].copy(comments = comments)
            it.copy(
                players = playersMut
            )
        }
    }

   fun addPlayerImage(playerIndex: Int, image: String) {
       _game.update {
           val playersMut = it.players.toMutableList()
           playersMut[playerIndex] = playersMut[playerIndex].copy(images = playersMut[playerIndex].images + image)
           it.copy(
               players = playersMut
           )
       }
   }

    fun removePlayerImage(playerIndex: Int, imageIndex: Int) {
        _game.update {
            val playersMut = it.players.toMutableList()
            val imagesMut = playersMut[playerIndex].images.toMutableList()
            imagesMut.removeAt(imageIndex)
            playersMut[playerIndex] = playersMut[playerIndex].copy(images = imagesMut)
            it.copy(
                players = playersMut
            )
        }
    }
}