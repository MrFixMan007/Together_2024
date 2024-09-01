package com.example.feature_login.screens.authorization_screen.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.common.domain.usecase.unauthenticated.AuthorizeUserUseCase
import com.example.feature_login.screens.authorization_screen.model.AuthorizationAction
import com.example.feature_login.screens.authorization_screen.model.AuthorizationSideEffect
import com.example.feature_login.screens.authorization_screen.model.AuthorizationState
import com.example.utils.PASSWORD_SHARED_PREFS
import com.example.utils.PHONE_SHARED_PREFS
import com.example.utils.TOKEN_NAME
import com.example.utils.TOKEN_SHARED_PREFS
import com.example.utils.isCorrectPhoneSymbolsAndLength
import com.example.utils.isValidPassword
import com.example.utils.isValidPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizeUserUseCase: AuthorizeUserUseCase,
) : ContainerHost<AuthorizationState, AuthorizationSideEffect>, ViewModel() {

    override val container = container<AuthorizationState, AuthorizationSideEffect>(
        AuthorizationState()
    )

    private val _sideEffects = MutableSharedFlow<AuthorizationSideEffect>()
    val sideEffects = _sideEffects.asSharedFlow()

    fun onAction(action: AuthorizationAction) = intent {
        when (action) {
            is AuthorizationAction.Authorize -> {
                if (!state.authorizeUserParam.password.isValidPassword()) {
                    reduce {
                        state.copy(isValidPassword = false)
                    }
                } else if (!state.isValidPassword) {
                    reduce {
                        state.copy(isValidPassword = true)
                    }
                }

                if (!state.authorizeUserParam.phoneNumber.isValidPhone()) {
                    reduce {
                        state.copy(isValidPhone = false)
                    }
                } else if (!state.isValidPhone) {
                    reduce {
                        state.copy(isValidPhone = true)
                    }
                }

                if (state.isValidPhone && state.isValidPassword) {
                    reduce {
                        state.copy(isLoadingAuthorization = true)
                    }
                    delay(500)

                    var phoneParam =
                        if (state.authorizeUserParam.phoneNumber[0] != '+') state.authorizeUserParam.phoneNumber else state.authorizeUserParam.phoneNumber.substring(
                            1
                        )
                    if (phoneParam[0] == '8') phoneParam = "7${phoneParam.substring(1)}"

                    val result = authorizeUserUseCase.execute(
                        authorizeUserParam = state.authorizeUserParam.copy(phoneNumber = phoneParam)
                    )

                    if (result.isSuccess) {
                        val sharedPreferences: SharedPreferences =
                            action.context.getSharedPreferences(
                                TOKEN_SHARED_PREFS, Context.MODE_PRIVATE
                            )
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString(TOKEN_NAME, result.token)
                        editor.putString(PHONE_SHARED_PREFS, state.authorizeUserParam.phoneNumber)
                        editor.putString(PASSWORD_SHARED_PREFS, state.authorizeUserParam.password)
                        editor.apply()
                        _sideEffects.emit(AuthorizationSideEffect.Completed)
                    } else {
                        _sideEffects.emit(AuthorizationSideEffect.Failed)
                    }

                    reduce {
                        state.copy(isLoadingAuthorization = false)
                    }
                }
            }

            is AuthorizationAction.PhoneChange -> {
                if (action.newValue.isCorrectPhoneSymbolsAndLength()) {
                    reduce {
                        state.copy(authorizeUserParam = state.authorizeUserParam.copy(phoneNumber = action.newValue))
                    }
                }
            }

            is AuthorizationAction.PasswordChange -> {
                reduce {
                    state.copy(authorizeUserParam = state.authorizeUserParam.copy(password = action.newValue))
                }
            }

            is AuthorizationAction.NavigateToRegistration -> {
                reduce {
                    state.copy(isEnabledRegisterNavigateButton = false)
                }
                _sideEffects.emit(AuthorizationSideEffect.NavigateToRegistration)

                delay(2000)
                if (!state.isEnabledRegisterNavigateButton) {
                    reduce {
                        state.copy(isEnabledRegisterNavigateButton = true)
                    }
                }

            }
        }
    }
}