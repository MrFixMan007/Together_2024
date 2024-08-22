package com.example.feature_login.registration_screen


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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.feature_login.navigation.navigateToAuthorizationScreen
import com.example.feature_login.components.ButtonInCenterWithCircleLoader
import com.example.feature_login.components.CustomNameField
import com.example.feature_login.components.CustomPasswordField
import com.example.feature_login.components.CustomPhoneField
import com.example.ui.R
import com.example.ui.components.ButtonInCenter
import com.example.ui.theme.ComposeTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import com.example.ui.theme.Typography
import com.example.ui.theme.Yellow

@Composable
fun RegistrationScreenContent(
    navController: NavController,
) {
    val viewModel: RegistrationViewModel = hiltViewModel()
    val state = viewModel.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.activate()
    }

    viewModel.collectSideEffect {
        when (it) {
            is RegistrationSideEffect.Failed -> {
                Toast.makeText(context, context.resources.getString(R.string.user_is_exist), Toast.LENGTH_SHORT).show()
            }

            is RegistrationSideEffect.Completed -> {
                Toast.makeText(context, "good :)", Toast.LENGTH_SHORT).show()
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
            viewModel = viewModel
        )
        SetBottomContent(
            context = context,
            navController = navController,
            state = state,
            viewModel = viewModel
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
    viewModel: RegistrationViewModel
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
                    viewModel.onFirstNameChange(it)
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
                    viewModel.onLastNameChange(it)
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
                    viewModel.onPhoneChange(it)
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
                    viewModel.onPasswordChange(it)
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
    navController: NavController,
    state: RegistrationState,
    viewModel: RegistrationViewModel
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
            viewModel.onRegister()
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
            viewModel.deactivate()
            navController.navigateToAuthorizationScreen()
        }
    }
}

@Preview
@Composable
private fun PreviewMainContent() {
    ComposeTheme {
        RegistrationScreenContent(rememberNavController())
    }
}