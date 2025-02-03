package com.devfall.gamecubby.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devfall.gamecubby.presentation.screens.home.Game

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
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
                text = "${game.playerIds.count()} players"
            )
            Text(
                text = "Last update: "
            )
        }
    }
}
