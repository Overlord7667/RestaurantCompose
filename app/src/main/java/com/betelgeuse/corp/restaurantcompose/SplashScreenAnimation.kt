package com.betelgeuse.corp.restaurantcompose

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val Background = Color(0xFFF15412)

@Composable
fun SplashScreen(
    onLoadingComplete: () -> Unit
) {
    var isFirstImageVisible by remember { mutableStateOf(true) }
    var isSecondImageVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(2000) // Задержка в 2 секунды для отображения первой картинки
        isFirstImageVisible = false // Исчезновение первой картинки
        delay(2000) // Задержка в 2 секунды перед появлением второй картинки
        isSecondImageVisible = true // Появление второй картинки
        delay(3000) // Задержка в 2 секунды перед завершением загрузки
        isSecondImageVisible = false // Исчезновение второй картинки
        delay(1600) // Задержка в 2 секунды перед завершением загрузки
        // После завершения загрузки, вызываем колбэк
        onLoadingComplete()
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Background),
        contentAlignment = Alignment.Center
    ) {
        // Первая анимация: исчезновение первой картинки
        AnimatedVisibility(
            visible = isFirstImageVisible,
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 2000
                )
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Вторая анимация: появление второй картинки
        AnimatedVisibility(
            visible = isSecondImageVisible,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 2000
                )
            ),
            exit = fadeOut(
                animationSpec = tween(
                    durationMillis = 2000
                )
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_2),
                contentDescription = null,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen {}
}