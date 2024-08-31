package com.example.navigation_unauthenticated

sealed class UnauthenticatedNavigation(
    val route: String
) {
    data object Authorization : UnauthenticatedNavigation(
        route = "authorization_screen"
    )

    data object Registration : UnauthenticatedNavigation(
        route = "registration_screen"
    )
}