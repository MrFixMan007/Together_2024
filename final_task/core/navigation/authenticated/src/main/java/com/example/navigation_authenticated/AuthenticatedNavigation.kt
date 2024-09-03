package com.example.navigation_authenticated

import androidx.navigation.NavController

const val MAIN_SCREEN_ROUTE = "main_screen_route"
const val DETAILS_SCREEN_ROUTE = "details_screen_route"

sealed class AuthenticatedNavigation(
    val route: String
) {
    data object Home : AuthenticatedNavigation(
        route = "home"
    )

    data object Favourites : AuthenticatedNavigation(
        route = "favourites"
    )

    data object Add : AuthenticatedNavigation(
        route = "add"
    )

    data object Message : AuthenticatedNavigation(
        route = "message"
    )

    data object Profile : AuthenticatedNavigation(
        route = "profile"
    )
}

fun NavController.navigateToMainScreen(
) {
    this.navigate(MAIN_SCREEN_ROUTE) {
        popUpTo(0){
            inclusive = true
        }
    }
}