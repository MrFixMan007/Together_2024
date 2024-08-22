package com.example.feature_login.screens.authorization_screen

import com.example.common.domain.model.AuthorizeUserParam


data class AuthorizationState(
    val authorizeUserParam: AuthorizeUserParam = AuthorizeUserParam("",""),
    val isValidPhone: Boolean = true,
    val isValidPassword: Boolean = true,
    val isEnabledRegisterNavigateButton: Boolean = false,
    val isLoadingAuthorization: Boolean = false
)

sealed class AuthorizationSideEffect {
    data object Failed : AuthorizationSideEffect()
    data object Completed : AuthorizationSideEffect()
}