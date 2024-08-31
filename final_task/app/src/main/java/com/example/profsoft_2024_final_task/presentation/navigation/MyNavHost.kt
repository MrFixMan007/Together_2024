package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.feature_login.navigation.authorizationScreen
import com.example.feature_login.navigation.registrationScreen
import com.example.feature_home_screen.screen.HomeScreenRoot
import com.example.ui.components.main_screen.mainScreen

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        authorizationScreen(navController = navController)
        registrationScreen(navController)
        mainScreen(
            homeScreenContent = { HomeScreenRoot(navController = navController) },
            favouritesScreenContent = { Text(text = "favouritesScreenContent") },
            addScreenContent = { Text(text = "addScreenContent") },
            messageScreenContent = { Text(text = "messageScreenContent") },
            profileScreenContent = { Text(text = "profileScreenContent") },
        )
    }
}