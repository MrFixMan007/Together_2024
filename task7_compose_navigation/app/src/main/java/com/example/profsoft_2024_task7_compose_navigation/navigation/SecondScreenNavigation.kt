package com.example.profsoft_2024_task7_compose_navigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profsoft_2024_task7_compose_navigation.secondscreen.SecondScreen

const val SECOND_SCREEN_ROUTE = "second_screen"

fun NavController.navigateToSecondScreen() {
    this.navigate(SECOND_SCREEN_ROUTE)
}

fun NavGraphBuilder.secondScreen(
    navController: NavController
) {
    composable(
        route = SECOND_SCREEN_ROUTE
    ) {
        SecondScreen(
            navController
        )
    }
}