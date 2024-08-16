package com.example.profsoft_2024_final_task.presentation.secondscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ActionBar
import com.example.profsoft_2024_final_task.presentation.secondscreen.components.RegistrationScreenContent
import com.example.profsoft_2024_final_task.presentation.theme.LightGray

@Composable
fun RegistrationScreen(
    navController: NavController,
    firstName: String,
    lastName: String,
    patronymic: String,
    birthday: String,
) {
    Column {
        ActionBar(
            title = LocalContext.current.resources.getString(R.string.profile),
            onBackClick = navController::popBackStack,
            containerColor = LightGray
        )
        RegistrationScreenContent(
            navController,
            firstName = firstName,
            lastName = lastName,
            patronymic = patronymic,
            birthday = birthday
        )
    }
}