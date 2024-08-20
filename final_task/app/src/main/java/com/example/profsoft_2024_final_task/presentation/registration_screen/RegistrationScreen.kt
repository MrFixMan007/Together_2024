package com.example.profsoft_2024_final_task.presentation.registration_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.profsoft_2024_final_task.presentation.registration_screen.content.RegistrationScreenContent

@Composable
fun RegistrationScreen(
    navController: NavController
) {
    Column {
        RegistrationScreenContent(
            navController,
        )
    }
}