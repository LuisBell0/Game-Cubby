package com.devfall.gamecubby.di

import android.content.Context
import androidx.room.Room
import com.devfall.gamecubby.data.database.AppDatabase
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import com.devfall.gamecubby.presentation.screens.home.HomeScreenViewModel
import com.devfall.gamecubby.presentation.screens.addgame.AddGameScreenViewModel

fun appModule(context: Context) = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::AddGameScreenViewModel)

    single {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app-database"
        ).build()
    }

    single { get<AppDatabase>().appDao() }
}


