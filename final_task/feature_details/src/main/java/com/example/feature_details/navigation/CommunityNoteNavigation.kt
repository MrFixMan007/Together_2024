package com.example.feature_details.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.feature_details.screen.community_note_screen.CommunityNoteScreenRoot
import com.example.navigation_authenticated.DETAILS_ID
import com.example.navigation_authenticated.DETAILS_SCREEN_ROUTE

private const val TRANSITION_DURATION = 300

fun NavGraphBuilder.communityNoteScreen(
    navController: NavController,
) {
    composable(
        route = "$DETAILS_SCREEN_ROUTE/{$DETAILS_ID}",
        arguments = listOf(
            navArgument(DETAILS_ID) {
                type = NavType.StringType
                nullable = false
            }
        ),
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        val idArgument = it.arguments?.getString(DETAILS_ID) ?: ""
        CommunityNoteScreenRoot(navController = navController, id = idArgument)
    }
}