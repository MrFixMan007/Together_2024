package com.example.feature_login.screens.authorization_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feature_login.navigation.OutNavigator

@Composable
fun AuthorizationScreen(
    navController: NavController,
    outNavigator: OutNavigator
) {
    Column {
        AuthorizationScreenContent(navController = navController, outNavigator = outNavigator)
    }
}