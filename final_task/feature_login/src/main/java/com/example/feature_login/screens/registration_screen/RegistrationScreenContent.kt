package com.example.feature_login.screens.registration_screen


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature_login.components.ButtonInCenterWithCircleLoader
import com.example.feature_login.components.CustomNameField
import com.example.feature_login.components.CustomPasswordField
import com.example.feature_login.components.CustomPhoneField
import com.example.feature_login.screens.registration_screen.model.RegistrationAction
import com.example.feature_login.screens.registration_screen.model.RegistrationSideEffect
import com.example.feature_login.screens.registration_screen.model.RegistrationState
import com.example.ui.R
import com.example.ui.components.ButtonInCenter
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.Typography
import com.example.ui.theme.Yellow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun RegistrationScreenContent(
    state: RegistrationState,
    sideEffects: Flow<RegistrationSideEffect>,
    onAction: (RegistrationAction) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(sideEffects) {
        sideEffects.collect { sideEffect ->
            when (sideEffect) {
                is RegistrationSideEffect.Failed -> {
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.user_is_exist),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> Unit
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow),
    ) {
        SetTopContent()
        SetCenterContent(
            context = context,
            state = state,
            onAction = onAction
        )
        SetBottomContent(
            context = context,
            state = state,
            onAction = onAction
        )
    }
}

@Composable
private fun SetTopContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.content_description)
        )
    }
}

@Composable
private fun SetCenterContent(
    context: Context,
    state: RegistrationState,
    onAction: (RegistrationAction) -> Unit
) {
    Column(modifier = Modifier.padding(top = 70.dp, start = 16.dp, end = 16.dp)) {
        val resources = context.resources
        Text(text = resources.getString(R.string.registration), style = Typography.headlineLarge)
        Text(
            text = resources.getString(R.string.entry_description),
            style = Typography.bodyMedium,
            modifier = Modifier.padding(top = 6.dp)
        )
        Column(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            CustomNameField(
                value = state.registerUserParam.firstName,
                placeholder = resources.getString(R.string.first_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                onValueChange = {
                    onAction(RegistrationAction.FirstNameChange(it))
                }
            )
            if (!state.isValidFirstName) {
                Text(
                    text = context.resources.getString(R.string.enter_the_first_name),
                    color = Color.Red,
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            CustomNameField(
                value = state.registerUserParam.lastName,
                placeholder = resources.getString(R.string.last_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                onValueChange = {
                    onAction(RegistrationAction.LastNameChange(it))
                }
            )
            if (!state.isValidLastName) {
                Text(
                    text = context.resources.getString(R.string.enter_the_last_name),
                    color = Color.Red,
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            CustomPhoneField(
                value = state.registerUserParam.phoneNumber,
                placeholder = resources.getString(R.string.phone_number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                onValueChange = {
                    onAction(RegistrationAction.PhoneChange(it))
                }
            )
            if (!state.isValidPhone) {
                Text(
                    text = context.resources.getString(R.string.incorrect_phone_number),
                    color = Color.Red,
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            CustomPasswordField(
                value = state.registerUserParam.password,
                placeholder = resources.getString(R.string.password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                onValueChange = {
                    onAction(RegistrationAction.PasswordChange(it))
                }
            )
            if (!state.isValidPassword) {
                Text(
                    text = context.resources.getString(R.string.incorrect_password),
                    color = Color.Red,
                    style = Typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

    }
}

@Composable
private fun SetBottomContent(
    context: Context,
    state: RegistrationState,
    onAction: (RegistrationAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ButtonInCenterWithCircleLoader(
            isLoading = state.isLoadingRegistration,
            buttonText = context.resources.getString(R.string.registration),
            bottomPadding = 12.dp
        ) {
            onAction(RegistrationAction.Register(context = context))
        }
        ButtonInCenter(
            modifier = Modifier.navigationBarsPadding(),
            buttonText = context.resources.getString(R.string.enter_with_account),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Yellow,
                disabledContentColor = Color.Black,
                disabledContainerColor = Yellow
            ),
            isButtonEnabled = state.isEnabledAuthorizeNavigateButton
        ) {
            onAction(RegistrationAction.NavigateToAuthorization)
        }
    }
}

@Preview
@Composable
private fun PreviewMainContent() {
    val fakeSideEffects: Flow<RegistrationSideEffect> = flowOf()
    val fakeOnAction: (RegistrationAction) -> Unit = { }
    ComposeTheme {
        RegistrationScreenContent(
            state = RegistrationState(),
            sideEffects = fakeSideEffects,
            onAction = fakeOnAction
        )
    }
}