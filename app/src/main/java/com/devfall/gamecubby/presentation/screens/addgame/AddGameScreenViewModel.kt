package com.devfall.gamecubby.presentation.screens.addgame

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.devfall.gamecubby.data.models.PlayersEntity


class AddGameScreenViewModel : ViewModel() {
    val playerNames = mutableStateMapOf<Int, String>()
    val playerComments = mutableStateMapOf<Int, String>()
    val players = mutableStateListOf<PlayersEntity>(PlayersEntity(id = 1, name = "", comments = "", image = ""))

    var imageUri = mutableStateOf<Uri?>(null)
    var showDialog = mutableStateOf(false)

    fun addPlayer() {
        val newId = players.size + 1
        players.add(PlayersEntity(id = newId, name = "", comments = "", image = ""))
        playerNames[newId] = ""
        playerComments[newId] = ""
    }

    fun removePlayer(player: PlayersEntity) {
        val indexToRemove = players.indexOf(player)
        if (indexToRemove == -1) return

        // Remove player
        players.removeAt(indexToRemove)
        playerNames.remove(player.id)
        playerComments.remove(player.id)

        // Shift remaining players' data and reassign IDs
        for (i in indexToRemove until players.size) {
            val nextPlayer = players[i]
            val newId = i + 1  // Ensure IDs remain sequential
            players[i] = nextPlayer.copy(id = newId)

            // Update the state maps for names and comments
            playerNames[newId] = playerNames[nextPlayer.id] ?: ""
            playerComments[newId] = playerComments[nextPlayer.id] ?: ""

            // Remove old keys to prevent duplicate keys
            playerNames.remove(nextPlayer.id)
            playerComments.remove(nextPlayer.id)
        }
    }
}