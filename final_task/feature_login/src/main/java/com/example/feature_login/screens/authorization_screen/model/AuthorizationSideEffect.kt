package com.example.feature_login.screens.authorization_screen.model

sealed class AuthorizationSideEffect {
    data object Failed : AuthorizationSideEffect()
    data object Completed : AuthorizationSideEffect()
    data object NavigateToRegistration : AuthorizationSideEffect()
}