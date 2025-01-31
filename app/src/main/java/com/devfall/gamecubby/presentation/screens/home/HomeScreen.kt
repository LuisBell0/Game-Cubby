package com.devfall.gamecubby.presentation.screens.home

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devfall.gamecubby.presentation.screens.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeScreenViewModel = viewModel()) {
    val games by viewModel.games.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchGames() // Fetch games when the screen loads
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Game Cubby",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            Button(
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    navController.navigate(route = Screen.AddGameScreen.route)
                }
            ) {
                Text("+ Add Game")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(games) { game ->
                GameCard(game)
            }
        }
    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp, pressedElevation = 4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = game.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
            )
            Text(
                text = "${game.numberOfPlayers} players"
            )
            Text(
                text = "Last update: "
            )
        }
    }
}