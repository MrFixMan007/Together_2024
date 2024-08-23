package com.example.feature_login.screens.registration_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feature_login.navigation.OutNavigator

@Composable
fun RegistrationScreen(
    navController: NavController,
    outNavigator: OutNavigator
) {
    Column {
        RegistrationScreenContent(
            navController = navController, outNavigator = outNavigator
        )
    }
}