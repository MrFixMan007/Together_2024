package com.example.feature_login.screens.authorization_screen.model

import android.content.Context

sealed class AuthorizationAction {
    data class PhoneChange(val newValue: String) : AuthorizationAction()
    data class PasswordChange(val newValue: String) : AuthorizationAction()
    data class Authorize(val context: Context) : AuthorizationAction()
    data object NavigateToRegistration : AuthorizationAction()
}