package com.example.feature_login.screens.authorization_screen.model

sealed class AuthorizationSideNavigate {
    data object Completed : AuthorizationSideNavigate()
    data object NavigateToRegistration : AuthorizationSideNavigate()
}