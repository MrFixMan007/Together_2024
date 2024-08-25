package com.example.ui.components.bottom_bar

import androidx.annotation.DrawableRes
import com.example.ui.R

sealed class BottomBarScreen(
    val route: String,
    @DrawableRes val icon: Int
) {
    data object Home : BottomBarScreen(
        route = "home",
        icon = R.drawable.home_icon
    )

    data object Favourites : BottomBarScreen(
        route = "favourites",
        icon = R.drawable.favourites_icon
    )

    data object Add : BottomBarScreen(
        route = "add",
        icon = R.drawable.add_icon
    )

    data object Message : BottomBarScreen(
        route = "message",
        icon = R.drawable.message_icon
    )

    data object Profile : BottomBarScreen(
        route = "profile",
        icon = R.drawable.profile_icon
    )
}
