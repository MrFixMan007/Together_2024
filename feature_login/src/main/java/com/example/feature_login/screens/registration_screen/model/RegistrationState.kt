package com.example.feature_login.screens.registration_screen.model

import com.example.common.domain.model.unauthenticated.RegisterUserParam

data class RegistrationState(
    val registerUserParam: RegisterUserParam = RegisterUserParam("", "", "", ""),
    val isValidPhone: Boolean = true,
    val isValidPassword: Boolean = true,
    val isValidFirstName: Boolean = true,
    val isValidLastName: Boolean = true,
    val isEnabledAuthorizeNavigateButton: Boolean = true,
    val isLoadingRegistration: Boolean = false
)