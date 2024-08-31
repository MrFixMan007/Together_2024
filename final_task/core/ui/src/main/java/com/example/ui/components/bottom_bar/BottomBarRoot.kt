package com.example.ui.components.bottom_bar

import androidx.annotation.DrawableRes
import com.example.navigation_authenticated.AuthenticatedNavigation
import com.example.ui.R

sealed class BottomBarRoot(
    val route: String,
    @DrawableRes val icon: Int
) {
    data object Home : BottomBarRoot(
        route = AuthenticatedNavigation.Home.route,
        icon = R.drawable.home_icon
    )

    data object Favourites : BottomBarRoot(
        route = AuthenticatedNavigation.Favourites.route,
        icon = R.drawable.favourites_icon
    )

    data object Add : BottomBarRoot(
        route = AuthenticatedNavigation.Add.route,
        icon = R.drawable.add_icon
    )

    data object Message : BottomBarRoot(
        route = AuthenticatedNavigation.Message.route,
        icon = R.drawable.message_icon
    )

    data object Profile : BottomBarRoot(
        route = AuthenticatedNavigation.Profile.route,
        icon = R.drawable.profile_icon
    )
}
