package com.devfall.gamecubby

import android.app.Application
import com.devfall.gamecubby.di.appModule
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule(this@MainApplication))
        }
    }
}