package com.example.feature_login.registration_screen

import com.example.common.domain.model.RegisterUserParam

data class RegistrationState(
    val registerUserParam: RegisterUserParam = RegisterUserParam("", "", "", ""),
    val isValidPhone: Boolean = true,
    val isValidPassword: Boolean = true,
    val isValidFirstName: Boolean = true,
    val isValidLastName: Boolean = true,
    val isEnabledAuthorizeNavigateButton: Boolean = false,
    val isLoadingRegistration: Boolean = false
)

sealed class RegistrationSideEffect {
    data object Failed : RegistrationSideEffect()
    data object Completed : RegistrationSideEffect()
}