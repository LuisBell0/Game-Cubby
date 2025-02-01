package com.devfall.gamecubby.presentation.screens.addgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devfall.gamecubby.presentation.screens.addgame.components.AddImageButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGameScreen() {
    var gameNameState by remember { mutableStateOf("") }
    var gameCommentState by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Add Game",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = 16.dp
            )
        ) {
            item(key = "game_title") {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = gameNameState,
                    onValueChange = {
                        gameNameState = it
                    },
                    label = {
                        Text(text = "Game Title")
                    },
                    singleLine = true,
                )
            }

            item(key = "game_comments") {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = gameCommentState,
                    onValueChange = {
                        gameCommentState = it
                    },
                    label = {
                        Text(text = "Game Comments")
                    },
                    minLines = 5,
                )
            }

            item(key = "add_image_button") {
                Spacer(modifier = Modifier.height(12.dp))
                AddImageButton()
            }
        }
    }
}

