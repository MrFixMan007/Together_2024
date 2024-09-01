package com.example.feature_login.screens.registration_screen.model

sealed class RegistrationSideNavigate {
    data object Completed : RegistrationSideNavigate()
    data object NavigateToAuthorization : RegistrationSideNavigate()
}