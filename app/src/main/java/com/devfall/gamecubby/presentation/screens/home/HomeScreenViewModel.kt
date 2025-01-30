package com.devfall.gamecubby.presentation.screens.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UserInfo(
    val name: String = "Luis",
    val favoriteColor: Color = Color.Green
)


class HomeScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(UserInfo(favoriteColor = Color.Red))
    val state = _state.asStateFlow()

    fun updateFavoriteColor(favoriteColor: Color) {
        viewModelScope.launch {
            _state.update { currentState ->
                currentState.copy(favoriteColor = favoriteColor)
            }
        }
    }

}