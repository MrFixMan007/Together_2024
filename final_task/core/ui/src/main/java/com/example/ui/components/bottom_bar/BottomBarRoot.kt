package com.example.ui.components.bottom_bar

import androidx.annotation.DrawableRes
import com.example.ui.R

sealed class BottomBarRoot(
    val route: String,
    @DrawableRes val icon: Int
) {
    data object Home : BottomBarRoot(
        route = "home",
        icon = R.drawable.home_icon
    )

    data object Favourites : BottomBarRoot(
        route = "favourites",
        icon = R.drawable.favourites_icon
    )

    data object Add : BottomBarRoot(
        route = "add",
        icon = R.drawable.add_icon
    )

    data object Message : BottomBarRoot(
        route = "message",
        icon = R.drawable.message_icon
    )

    data object Profile : BottomBarRoot(
        route = "profile",
        icon = R.drawable.profile_icon
    )
}
