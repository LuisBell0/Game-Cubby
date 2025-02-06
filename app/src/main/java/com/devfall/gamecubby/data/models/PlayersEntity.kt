package com.devfall.gamecubby.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "players",
//    foreignKeys = [ForeignKey(
//        entity = GamesEntity::class,
//        parentColumns = ["id"],
//        childColumns = ["gameId"],
//        onDelete = ForeignKey.CASCADE
//    )]
)
data class PlayersEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val comments: String,
    val image: String,
//    val gameId: Int,
)
