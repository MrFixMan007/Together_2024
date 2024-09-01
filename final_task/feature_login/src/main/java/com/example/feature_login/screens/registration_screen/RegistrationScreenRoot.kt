package com.example.feature_login.screens.registration_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.feature_login.screens.registration_screen.model.RegistrationSideNavigate
import com.example.feature_login.screens.registration_screen.viewmodel.RegistrationViewModel
import com.example.navigation_authenticated.navigateToMainScreen
import com.example.navigation_unauthenticated.navigateToAuthorizationScreen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun RegistrationScreenRoot(
    navController: NavController
) {
    val viewModel: RegistrationViewModel = hiltViewModel()
    val sideEffects = viewModel.sideNavigate

    LaunchedEffect(sideEffects) {
        sideEffects.collect { sideEffect ->
            when (sideEffect) {
                is RegistrationSideNavigate.Completed -> navController.navigateToMainScreen()
                is RegistrationSideNavigate.NavigateToAuthorization -> navController.navigateToAuthorizationScreen()
            }
        }
    }

    Column {
        RegistrationScreenContent(
            state = viewModel.collectAsState().value,
            sideEffects = viewModel.container.sideEffectFlow,
            onAction = { action -> viewModel.onAction(action) })
    }
}