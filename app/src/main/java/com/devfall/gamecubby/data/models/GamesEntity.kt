package com.devfall.gamecubby.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GamesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val comments: String,
/*    val images: List<String>,
    val playerIds: List<Int>*/
)
