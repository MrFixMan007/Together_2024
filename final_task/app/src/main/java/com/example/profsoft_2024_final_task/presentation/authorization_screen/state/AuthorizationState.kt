package com.example.profsoft_2024_final_task.presentation.authorization_screen.state

import com.example.profsoft_2024_final_task.domain.model.AuthorizeUserParam


data class AuthorizationState(
    val authorizeUserParam: AuthorizeUserParam = AuthorizeUserParam("",""),
    val isValidPhone: Boolean = true,
    val isValidPassword: Boolean = true,
    val isEnabledRegisterNavigateButton: Boolean = false,
    val isLoadingAuthorization: Boolean = false
)

sealed class AuthorizationSideEffect {
    data object Load : AuthorizationSideEffect()
}