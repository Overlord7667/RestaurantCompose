package com.betelgeuse.corp.restaurantcompose

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.betelgeuse.corp.restaurantcompose.MainMenu // Импорт MainMenu из MainUi.kt
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT // Установка ориентации на портретную
        setContent {
            SplashScreen(onLoadingComplete = {
                navigateToMainMenu()
            })
        }
    }

    private fun navigateToMainMenu() {
        setContent {
            MainMenu {}
        }
    }
}