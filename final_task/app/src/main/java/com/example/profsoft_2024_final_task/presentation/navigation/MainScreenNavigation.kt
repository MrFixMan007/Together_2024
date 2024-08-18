package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.profsoft_2024_final_task.presentation.authorization_screen.AuthorizationScreen

const val AUTHORIZATION_SCREEN_ROUTE = "authorization_screen"
private const val TRANSITION_DURATION = 300

fun NavController.navigateToAuthorizationScreen() {
    this.navigate(AUTHORIZATION_SCREEN_ROUTE) {
        popUpTo(AUTHORIZATION_SCREEN_ROUTE) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.authorizationScreen(
    navController: NavController
) {
    composable(
        route = AUTHORIZATION_SCREEN_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        AuthorizationScreen(
            navController
        )
    }
}