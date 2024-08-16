package com.example.profsoft_2024_final_task.presentation.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.profsoft_2024_final_task.presentation.mainscreen.components.AuthorizationScreenContent

@Composable
fun AuthorizationScreen(
    navController: NavController
) {
    Column {
        AuthorizationScreenContent(navController)
    }
}