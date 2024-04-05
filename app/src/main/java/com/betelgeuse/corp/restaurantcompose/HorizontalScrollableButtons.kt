package com.betelgeuse.corp.restaurantcompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HorizontalScrollableButtons() {
    val buttonList = listOf("Роллы", "Суши", "Наборы", "Горячие блюда", "Корзина")

    // Состояние для отслеживания индекса выбранной кнопки
    val (selectedButtonIndex, setSelectedButtonIndex) = remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(buttonList) { index, buttonText ->
            Button(
                onClick = {
                    // При нажатии на кнопку устанавливаем индекс выбранной кнопки
                    setSelectedButtonIndex(index)
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp) // Добавляем отступы между кнопками
                    .wrapContentWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (index == selectedButtonIndex) Background else Color.Transparent, // Устанавливаем цвет фона кнопки в зависимости от выбранной кнопки
                    contentColor = if (index == selectedButtonIndex) Color.White else Color.Black, // Устанавливаем цвет текста в зависимости от выбранной кнопки
                ),
                elevation = ButtonDefaults.elevation(0.dp), // Убираем тень
                border = null// Убираем рамку вокруг кнопки
            ) {
                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}