package com.example.profsoft_2024_final_task.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.component.ActionBar
import com.example.profsoft_2024_final_task.mainscreen.components.MainScreenContent

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