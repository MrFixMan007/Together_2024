package com.example.profsoft_2024_final_task.presentation.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ButtonInCenter
import com.example.profsoft_2024_final_task.presentation.navigation.navigateToSecondScreen
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Yellow

@Composable
fun AuthorizationScreenContent(navController: NavController) {
    val resources = LocalContext.current.resources
    Column(
        modifier = Modifier
            .fillMaxSize().background(Yellow),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ButtonInCenter(
            buttonText = resources.getString(R.string.enter),
            bottomPadding = 12.dp
        ) {
            navController.navigateToSecondScreen(
                firstName = "Ivan",
                lastName = "Ivanov",
                patronymic = "Ivanovich",
                birthday = "01.01.2005"
            )
        }
        ButtonInCenter(
            buttonText = resources.getString(R.string.registration),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Yellow
            )
        ) {
            navController.navigateToSecondScreen(
                firstName = "Ivan",
                lastName = "Ivanov",
                patronymic = "Ivanovich",
                birthday = "01.01.2005"
            )
        }
    }
}

@Preview
@Composable
private fun PreviewMainContent() {
    ComposeTheme {
        AuthorizationScreenContent(rememberNavController())
    }
}