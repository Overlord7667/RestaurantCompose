package com.betelgeuse.corp.restaurantcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.ui.res.painterResource

@Composable
fun MainMenu(onLoadingComplete: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
            Spacer(modifier = Modifier.height(16.dp))
            // Добавляем Row для размещения элементов горизонтально
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Добавляем ImageButton здесь
                IconButton(
                    onClick = { /* Обработчик нажатия */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.sort_product), // Замените R.drawable.your_image на свой ресурс изображения
                        contentDescription = "Custom Image"
                    )
                }
                // Отображаем изображение с помощью Icon
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Custom Image",
                    modifier = Modifier.size(78.dp)
                )
                IconButton(
                    onClick = { /* Обработчик нажатия */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_product), // Замените R.drawable.your_image на свой ресурс изображения
                        contentDescription = "Custom Image"
                    )
                }
            }
            HorizontalScrollableButtons()
            CardListUI()
        }
    }
}
@Preview
@Composable
fun PreviewMainMenu() {
    MainMenu {}
}