package com.example.feature_login.registration_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

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