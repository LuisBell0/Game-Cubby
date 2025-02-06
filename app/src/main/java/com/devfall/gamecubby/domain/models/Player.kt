package com.devfall.gamecubby.domain.models

data class Player(
    val id: Int,
    val name: String = "",
    val comments: String = "",
    val images: List<String> = emptyList(),
)
