package com.example.feature_login.screens.registration_screen.model

sealed class RegistrationSideEffect {
    data object Failed : RegistrationSideEffect()
    data object Completed : RegistrationSideEffect()
    data object NavigateToAuthorization : RegistrationSideEffect()
}