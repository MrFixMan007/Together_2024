package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.feature_login.navigation.authorizationScreen
import com.example.feature_login.navigation.registrationScreen

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        authorizationScreen(navController)
        registrationScreen(navController)
    }
}