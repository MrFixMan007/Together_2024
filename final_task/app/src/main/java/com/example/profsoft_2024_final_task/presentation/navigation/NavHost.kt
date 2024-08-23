package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.feature_login.navigation.OutNavigator
import com.example.feature_login.navigation.authorizationScreen
import com.example.feature_login.navigation.registrationScreen

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    outNavigator: OutNavigator
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        authorizationScreen(navController = navController, outNavigator = outNavigator)
        registrationScreen(navController, outNavigator = outNavigator)
    }
}