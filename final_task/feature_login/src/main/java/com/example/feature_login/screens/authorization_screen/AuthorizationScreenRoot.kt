package com.example.feature_login.screens.authorization_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.feature_login.screens.authorization_screen.viewmodel.AuthorizationViewModel
import com.example.feature_login.screens.authorization_screen.model.AuthorizationSideEffect
import com.example.navigation_authenticated.navigateToMainScreen
import com.example.navigation_unauthenticated.navigateToRegistrationScreen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun AuthorizationScreenRoot(
    navController: NavController
) {
    val viewModel: AuthorizationViewModel = hiltViewModel()
    val sideEffects = viewModel.sideEffects

    LaunchedEffect(sideEffects) {
        sideEffects.collect { sideEffect ->
            when(sideEffect) {
                is AuthorizationSideEffect.Completed -> navController.navigateToMainScreen()
                is AuthorizationSideEffect.NavigateToRegistration -> navController.navigateToRegistrationScreen()
                else -> Unit
            }
        }
    }

    Column {
        AuthorizationScreenContent(
            state = viewModel.collectAsState().value,
            sideEffects = sideEffects,
            onAction = { action -> viewModel.onAction(action) })
    }
}