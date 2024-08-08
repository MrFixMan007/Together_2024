package com.example.profsoft_2024_task7_compose_navigation.mainscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.SetButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.navigation.navigateToSecondScreen

@Composable
fun MainScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        SetButtonInCenter(
            buttonText = LocalContext.current.resources.getString(R.string.profile),
        ) {
            navController.navigateToSecondScreen()
        }
    }
}

@Preview
@Composable
private fun PreviewMainContent() {
    MainScreenContent(rememberNavController())
}