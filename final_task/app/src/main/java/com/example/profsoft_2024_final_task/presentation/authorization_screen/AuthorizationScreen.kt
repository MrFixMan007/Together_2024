package com.example.profsoft_2024_final_task.presentation.authorization_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.profsoft_2024_final_task.presentation.authorization_screen.components.AuthorizationScreenContent

@Composable
fun AuthorizationScreen(
    navController: NavController
) {
    Column {
        AuthorizationScreenContent(navController)
    }
}