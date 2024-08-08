package com.example.profsoft_2024_task7_compose_navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profsoft_2024_task7_compose_navigation.mainscreen.MainScreen

const val MAIN_SCREEN_ROUTE = "main_screen"

fun NavController.navigateToMainScreen() {
    this.navigate(MAIN_SCREEN_ROUTE)
}

fun NavGraphBuilder.mainScreen(
    navController: NavController
) {
    composable(
        route = MAIN_SCREEN_ROUTE
    ) {
        MainScreen(
            navController
        )
    }
}