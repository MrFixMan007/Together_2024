package com.example.feature_login.screens.authorization_screen

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.common.domain.usecase.AuthorizeUserUseCase
import com.example.utils.shared_prefs.TOKEN_NAME
import com.example.utils.shared_prefs.TOKEN_SHARED_PREFS
import com.example.utils.validation.isCorrectPhoneSymbolsAndLength
import com.example.utils.validation.isValidPassword
import com.example.utils.validation.isValidPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    fun onAuthorize(context: Context) = intent {

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

            var phoneParam = if (state.authorizeUserParam.phoneNumber[0] != '+') state.authorizeUserParam.phoneNumber else state.authorizeUserParam.phoneNumber.substring(1)
            if (phoneParam[0] == '8') phoneParam = "7${phoneParam.substring(1)}"

            val result = authorizeUserUseCase.execute(
                authorizeUserParam = state.authorizeUserParam.copy(phoneNumber = phoneParam)
            )

            if (result.isSuccess) {
                val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                    TOKEN_SHARED_PREFS, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(TOKEN_NAME, result.token)
                editor.apply()
                postSideEffect(AuthorizationSideEffect.Completed)
            } else {
                postSideEffect(AuthorizationSideEffect.Failed)
            }

            reduce {
                state.copy(isLoadingAuthorization = false)
            }
        }
    }

    fun onPhoneChange(newValue: String) = intent {
        if (newValue.isCorrectPhoneSymbolsAndLength()) {
            reduce {
                state.copy(authorizeUserParam = state.authorizeUserParam.copy(phoneNumber = newValue))
            }
        }
    }

    fun onPasswordChange(newValue: String) = intent {
        reduce {
            state.copy(authorizeUserParam = state.authorizeUserParam.copy(password = newValue))
        }
    }

    fun deactivate() = intent {
        reduce {
            state.copy(isEnabledRegisterNavigateButton = false)
        }
        delay(2000)
        if (!state.isEnabledRegisterNavigateButton) {
            reduce {
                state.copy(isEnabledRegisterNavigateButton = true)
            }
        }

    }

    fun activate() = intent {
        delay(1000)
        reduce {
            state.copy(isEnabledRegisterNavigateButton = true)
        }
    }

}