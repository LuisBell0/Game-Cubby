package com.devfall.gamecubby.domain.models

data class Game(
    val id: Int,
    val name: String,
    val comments: String,
    val images: List<String>,
    val players: List<Player>
)
