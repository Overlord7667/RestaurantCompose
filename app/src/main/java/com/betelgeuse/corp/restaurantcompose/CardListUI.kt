package com.betelgeuse.corp.restaurantcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment

@Composable
fun CardListUI() {
    val cardList = listOf(
        "Card 1", "Card 2", "Card 3", "Card 4", "Card 5", "Card 6", "Card 7", "Card 8"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(cardList.chunked(2)) { rowItems ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(rowItems) { card ->
                    Button(
                        onClick = { /* Обработчик нажатия на карточку */ },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = card)
                    }
                }
            }
        }
    }
}