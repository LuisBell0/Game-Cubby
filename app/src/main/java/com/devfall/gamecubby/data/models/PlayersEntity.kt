package com.devfall.gamecubby.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "players")
data class PlayersEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val comments: String,
    val images: String
)
