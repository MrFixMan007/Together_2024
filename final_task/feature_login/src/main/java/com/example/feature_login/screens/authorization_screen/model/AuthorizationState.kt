package com.example.feature_login.screens.authorization_screen.model

import com.example.common.domain.model.unauthenticated.AuthorizeUserParam


data class AuthorizationState(
    val authorizeUserParam: AuthorizeUserParam = AuthorizeUserParam("",""),
    val isValidPhone: Boolean = true,
    val isValidPassword: Boolean = true,
    val isEnabledRegisterNavigateButton: Boolean = true,
    val isLoadingAuthorization: Boolean = false
)