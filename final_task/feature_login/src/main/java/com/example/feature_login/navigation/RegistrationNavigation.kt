package com.example.feature_login.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature_login.screens.registration_screen.RegistrationScreen

const val REGISTRATION_SCREEN_ROUTE = "registration_screen"
private const val TRANSITION_DURATION = 300

fun NavController.navigateToRegistrationScreen(
) {
    this.navigate(REGISTRATION_SCREEN_ROUTE)
}

fun NavGraphBuilder.registrationScreen(
    navController: NavController,
    outNavigator: OutNavigator
) {
    composable(
        route = REGISTRATION_SCREEN_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        RegistrationScreen(
            navController = navController,
            outNavigator = outNavigator
        )
    }
}