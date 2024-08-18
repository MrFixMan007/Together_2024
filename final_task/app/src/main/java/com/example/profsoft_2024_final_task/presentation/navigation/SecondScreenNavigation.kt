package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.profsoft_2024_final_task.presentation.registration_screen.RegistrationScreen

const val SECOND_SCREEN_ROUTE = "second_screen"
private const val TRANSITION_DURATION = 300
private const val FIRST_NAME_KEY = "first_name_key"
private const val LAST_NAME_KEY = "last_name_key"
private const val PATRONYMIC_KEY = "patronymic_key"
private const val BIRTHDAY_KEY = "birthday_key"

fun NavController.navigateToSecondScreen(
    firstName: String?,
    lastName: String?,
    patronymic: String?,
    birthday: String?,
) {
    this.navigate("$SECOND_SCREEN_ROUTE/$firstName/$lastName/$patronymic/$birthday")
}

fun NavGraphBuilder.secondScreen(
    navController: NavController
) {
    composable(
        route = "$SECOND_SCREEN_ROUTE/{$FIRST_NAME_KEY}/{$LAST_NAME_KEY}/{$PATRONYMIC_KEY}/{$BIRTHDAY_KEY}",
        arguments = listOf(
            navArgument(FIRST_NAME_KEY) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(LAST_NAME_KEY) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(PATRONYMIC_KEY) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(BIRTHDAY_KEY) {
                type = NavType.StringType
                nullable = true
            }
        ),
        enterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
        exitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popExitTransition = { fadeOut(tween(TRANSITION_DURATION)) },
        popEnterTransition = { fadeIn(tween(TRANSITION_DURATION)) },
    ) {
        val firstNameArgument = it.arguments?.getString(FIRST_NAME_KEY) ?: ""
        val lastNameArgument = it.arguments?.getString(LAST_NAME_KEY) ?: ""
        val patronymicArgument = it.arguments?.getString(PATRONYMIC_KEY) ?: ""
        val birthdayArgument = it.arguments?.getString(BIRTHDAY_KEY) ?: ""

        RegistrationScreen(
            navController,
            firstName = firstNameArgument,
            lastName = lastNameArgument,
            patronymic = patronymicArgument,
            birthday = birthdayArgument,
        )
    }
}