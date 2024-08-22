package com.example.feature_login.screens.authorization_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AuthorizationScreen(
    navController: NavController
) {
    Column {
        AuthorizationScreenContent(navController)
    }
}