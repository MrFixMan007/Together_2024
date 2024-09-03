package com.example.ui.components.main_screen

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation_authenticated.AuthenticatedNavigation
import com.example.navigation_authenticated.DETAILS_SCREEN_ROUTE
import com.example.navigation_authenticated.MAIN_SCREEN_ROUTE
import com.example.ui.components.MyTopBarWithSearch
import com.example.ui.components.bottom_bar.BottomBarRoot
import com.example.ui.components.bottom_bar.BottomBarScreen

private const val TRANSITION_DURATION = 300

fun NavGraphBuilder.mainScreen(
    homeScreenContent: @Composable () -> Unit,
    favouritesScreenContent: @Composable () -> Unit,
    addScreenContent: @Composable () -> Unit,
    messageScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    communityNoteScreenContent: @Composable () -> Unit,
) {
    composable(
        route = MAIN_SCREEN_ROUTE,
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        val innerNavController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBarScreen(navController = innerNavController) },
            topBar = {
                MyTopBarWithSearch(
                    title = "Главная",
                    onSearchClick = {})
            }) { paddingValues ->

            InnerNavHost(
                navController = innerNavController,
                modifier = Modifier.padding(paddingValues),
                homeScreenContent = homeScreenContent,
                favouritesScreenContent = favouritesScreenContent,
                addScreenContent = addScreenContent,
                messageScreenContent = messageScreenContent,
                profileScreenContent = profileScreenContent
            )
        }
    }
    composable(DETAILS_SCREEN_ROUTE) { communityNoteScreenContent() }
}

@Composable
private fun InnerNavHost(
    navController: NavHostController,
    modifier: Modifier,
    homeScreenContent: @Composable () -> Unit,
    favouritesScreenContent: @Composable () -> Unit,
    addScreenContent: @Composable () -> Unit,
    messageScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {

    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = BottomBarRoot.Home.route,
        modifier = modifier
    ) {
        composable(AuthenticatedNavigation.Home.route) { homeScreenContent() }
        composable(BottomBarRoot.Favourites.route) { favouritesScreenContent() }
        composable(BottomBarRoot.Add.route) { addScreenContent() }
        composable(BottomBarRoot.Message.route) { messageScreenContent() }
        composable(BottomBarRoot.Profile.route) { profileScreenContent() }
    }
}