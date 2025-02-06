package com.devfall.gamecubby.presentation.screens.addgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGameScreen() {
    var gameNameState by remember { mutableStateOf("") }
    var gameCommentState by remember { mutableStateOf("") }

    val viewModel = koinViewModel<AddGameScreenViewModel>()
    val game by viewModel.game.collectAsStateWithLifecycle()

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
            ),
        ) {
            item(key = "game_title") {
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = gameNameState,
                    onValueChange = {
                        gameNameState = it
                    },
                    placeholder = {
                        Text(text = "Game Title")
                    },
                    singleLine = true,
                )
            }

            item(key = "game_comments") {
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = gameCommentState,
                    onValueChange = {
                        gameCommentState = it
                    },
                    placeholder = {
                        Text(text = "Game Comments")
                    },
                    minLines = 5,
                )
            }

/*            item(key = "add_game_image_button") {
                Spacer(modifier = Modifier.height(12.dp))
                AddImageButton()
            }*/

            items(count = game.players.count(), key = { "player_card_$it" }) { index ->
                val player = game.players[index]
                Spacer(modifier = Modifier.height(12.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp, pressedElevation = 4.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth().height(24.dp),
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.CenterStart),
                                text = "Player ${player.id + 1}",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                            if (game.players.count() > 1) {
                                IconButton(
                                    modifier = Modifier.align(Alignment.CenterEnd),
                                    onClick = {
                                        viewModel.removePlayer(player.id)
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(0.dp),
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = null,
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = player.name,
                            onValueChange = {
                                viewModel.updatePlayerName(playerIndex = index, name = it)
                            },
                            placeholder = {
                                Text(text = "Player Name")
                            },
                            singleLine = true,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = player.comments,
                            onValueChange = {
                                viewModel.updatePlayerComments(playerIndex = index, comments = it)
                            },
                            placeholder = {
                                Text(text = "Player Comments")
                            },
                            minLines = 5,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        //AddImageButton()
                    }
                }
            }

            item(key = "add_player_button") {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    onClick = {
                        viewModel.addPlayer()
                    }
                ) {
                    Text(text = "Add Player")
                }
            }
            item(key="add_game_button") {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    onClick = {}
                ) {
                    Text(text = "Add Game")
                }
            }
        }
    }
}

