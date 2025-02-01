package com.devfall.gamecubby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devfall.gamecubby.presentation.screens.base.BaseScreen
import com.devfall.gamecubby.presentation.theme.GameCubbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameCubbyTheme {
                BaseScreen()
            }
        }
    }
}