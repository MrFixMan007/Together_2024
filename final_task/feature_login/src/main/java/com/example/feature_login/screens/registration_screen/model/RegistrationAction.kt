package com.example.feature_login.screens.registration_screen.model

import android.content.Context

sealed class RegistrationAction {
    data class FirstNameChange(val newValue: String) : RegistrationAction()
    data class LastNameChange(val newValue: String) : RegistrationAction()
    data class PhoneChange(val newValue: String) : RegistrationAction()
    data class PasswordChange(val newValue: String) : RegistrationAction()
    data class Register(val context: Context) : RegistrationAction()
    data object NavigateToAuthorization : RegistrationAction()
}