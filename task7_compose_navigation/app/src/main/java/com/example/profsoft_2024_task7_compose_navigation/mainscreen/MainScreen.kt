package com.example.profsoft_2024_task7_compose_navigation.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.ActionBar
import com.example.profsoft_2024_task7_compose_navigation.mainscreen.components.MainScreenContent
import com.example.profsoft_2024_task7_compose_navigation.theme.LightGray

@Composable
fun MainScreen(
    navController: NavController
) {
    Column {
        ActionBar(
            title = LocalContext.current.resources.getString(R.string.main_activity_title),
        )
        MainScreenContent(navController)
    }
}