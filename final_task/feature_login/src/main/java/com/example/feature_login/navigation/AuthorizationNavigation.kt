package com.example.feature_login.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature_login.screens.authorization_screen.AuthorizationScreenRoot
import com.example.navigation_unauthenticated.UnauthenticatedNavigation

private const val TRANSITION_DURATION = 300

fun NavGraphBuilder.authorizationScreen(
    navController: NavController
) {
    composable(
        route = UnauthenticatedNavigation.AUTHORIZATION_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        AuthorizationScreenRoot(
            navController = navController
        )
    }
}