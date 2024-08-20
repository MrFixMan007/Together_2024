package com.example.profsoft_2024_final_task.presentation.registration_screen.state

import com.example.profsoft_2024_final_task.domain.model.RegisterUserParam

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
    data object Load : RegistrationSideEffect()
}