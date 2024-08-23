package com.example.feature_login.screens.registration_screen


import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.example.common.domain.usecase.RegisterUserUseCase
import com.example.utils.shared_prefs.TOKEN_NAME
import com.example.utils.shared_prefs.TOKEN_SHARED_PREFS
import com.example.utils.validation.isCorrectPhoneSymbolsAndLength
import com.example.utils.validation.isValidName
import com.example.utils.validation.isValidPassword
import com.example.utils.validation.isValidPhone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registerUseCase: RegisterUserUseCase,
) : ContainerHost<RegistrationState, RegistrationSideEffect>, ViewModel() {

    override val container = container<RegistrationState, RegistrationSideEffect>(
        RegistrationState()
    )

    fun onRegister(context: Context) = intent {

        if (!state.registerUserParam.password.isValidPassword()) {
            reduce {
                state.copy(isValidPassword = false)
            }
        } else if (!state.isValidPassword) {
            reduce {
                state.copy(isValidPassword = true)
            }
        }

        if (!state.registerUserParam.phoneNumber.isValidPhone()) {
            reduce {
                state.copy(isValidPhone = false)
            }
        } else if (!state.isValidPhone) {
            reduce {
                state.copy(isValidPhone = true)
            }
        }

        if (!state.registerUserParam.firstName.isValidName() || state.registerUserParam.firstName.isEmpty()) {
            reduce {
                state.copy(isValidFirstName = false)
            }
        } else if (!state.isValidFirstName) {
            reduce {
                state.copy(isValidFirstName = true)
            }
        }

        if (!state.registerUserParam.lastName.isValidName() || state.registerUserParam.lastName.isEmpty()) {
            reduce {
                state.copy(isValidLastName = false)
            }
        } else if (!state.isValidLastName) {
            reduce {
                state.copy(isValidLastName = true)
            }
        }

        if (state.isValidPhone && state.isValidPassword && state.isValidFirstName && state.isValidLastName) {
            reduce {
                state.copy(isLoadingRegistration = true)
            }
            delay(500)

            var phoneParam = if (state.registerUserParam.phoneNumber[0] != '+') state.registerUserParam.phoneNumber else state.registerUserParam.phoneNumber.substring(1)
            if (phoneParam[0] == '8') phoneParam = "7${phoneParam.substring(1)}"

            val result = registerUseCase.execute(
                registerUserParam = state.registerUserParam.copy(phoneNumber = phoneParam)
            )

            if (result.isSuccess) {
                val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                    TOKEN_SHARED_PREFS, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(TOKEN_NAME, result.token)
                editor.apply()
                postSideEffect(RegistrationSideEffect.Completed)
            } else {
                postSideEffect(RegistrationSideEffect.Failed)
            }

            reduce {
                state.copy(isLoadingRegistration = false)
            }
        }
    }

    fun onFirstNameChange(newValue: String) = intent {
        if (newValue.isValidName()) {
            reduce {
                state.copy(registerUserParam = state.registerUserParam.copy(firstName = newValue))
            }
        }
    }

    fun onLastNameChange(newValue: String) = intent {
        if (newValue.isValidName()) {
            reduce {
                state.copy(registerUserParam = state.registerUserParam.copy(lastName = newValue))
            }
        }
    }


    fun onPhoneChange(newValue: String) = intent {
        if (newValue.isCorrectPhoneSymbolsAndLength()) {
            reduce {
                state.copy(registerUserParam = state.registerUserParam.copy(phoneNumber = newValue))
            }
        }
    }

    fun onPasswordChange(newValue: String) = intent {
        reduce {
            state.copy(registerUserParam = state.registerUserParam.copy(password = newValue))
        }
    }

    fun deactivate() = intent {
        reduce {
            state.copy(isEnabledAuthorizeNavigateButton = false)
        }
        delay(2000)
        if (!state.isEnabledAuthorizeNavigateButton) {
            reduce {
                state.copy(isEnabledAuthorizeNavigateButton = true)
            }
        }
    }

    fun activate() = intent {
        delay(1000)
        reduce {
            state.copy(isEnabledAuthorizeNavigateButton = true)
        }
    }

}