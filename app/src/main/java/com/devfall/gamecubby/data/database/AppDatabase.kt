package com.devfall.gamecubby.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devfall.gamecubby.data.dao.AppDao
import com.devfall.gamecubby.data.models.GamesEntity
import com.devfall.gamecubby.data.models.PlayersEntity

@Database(entities = [GamesEntity::class, PlayersEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}