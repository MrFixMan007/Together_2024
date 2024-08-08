package com.example.profsoft_2024_task7_compose_navigation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profsoft_2024_task7_compose_navigation.thirdscreen.ThirdScreen

const val THIRD_SCREEN_ROUTE = "third_screen"
private const val TRANSITION_DURATION = 300

fun NavController.navigateToThirdScreen() {
    this.navigate(THIRD_SCREEN_ROUTE)
}

fun NavGraphBuilder.thirdScreen(
    navController: NavController
) {
    composable(
        route = THIRD_SCREEN_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        ThirdScreen(
            navController
        )
    }
}