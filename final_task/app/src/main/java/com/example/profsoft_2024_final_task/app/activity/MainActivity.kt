package com.example.profsoft_2024_final_task.app.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.presentation.navigation.AUTHORIZATION_SCREEN_ROUTE
import com.example.profsoft_2024_final_task.presentation.navigation.NavHost
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ComposeTheme {
                NavHost(navController = navController, startDestination = AUTHORIZATION_SCREEN_ROUTE)
            }
        }
    }
}