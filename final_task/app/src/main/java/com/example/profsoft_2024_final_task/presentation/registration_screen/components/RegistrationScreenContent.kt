package com.example.profsoft_2024_final_task.presentation.registration_screen.components

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ButtonInCenter
import com.example.profsoft_2024_final_task.presentation.component.CustomNameField
import com.example.profsoft_2024_final_task.presentation.component.CustomPasswordField
import com.example.profsoft_2024_final_task.presentation.component.CustomPhoneField
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Typography
import com.example.profsoft_2024_final_task.presentation.theme.Yellow
import kotlinx.coroutines.delay

@Composable
fun RegistrationScreenContent(
    navController: NavController,
) {
    val context = LocalContext.current
    val phoneTextState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordTextState = remember { mutableStateOf(TextFieldValue("")) }
    val firstNameTextState = remember { mutableStateOf(TextFieldValue("")) }
    val lastNameTextState = remember { mutableStateOf(TextFieldValue("")) }
    val isValidPhoneState = remember { mutableStateOf(false) }
    val isValidPasswordState = remember { mutableStateOf(false) }
    val isValidFirstNameState = remember { mutableStateOf(false) }
    val isValidLastNameState = remember { mutableStateOf(false) }

    val isAuthorizeButtonEnabledState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }
    val isRegisterButtonEnabledState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(300)
        isAuthorizeButtonEnabledState.value = true
        isRegisterButtonEnabledState.value = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow),
    ) {
        SetTopContent()
        SetCenterContent(
            context = context,
            phoneTextState = phoneTextState,
            passwordTextState = passwordTextState,
            firstNameTextState = firstNameTextState,
            lastNameTextState = lastNameTextState,
            isValidPhoneState = isValidPhoneState,
            isValidPasswordState = isValidPasswordState,
            isValidFirstNameState = isValidFirstNameState,
            isValidLastNameState = isValidLastNameState
        )
        SetBottomContent(
            context = context,
            navController = navController,
            isValidPhoneState = isValidPhoneState,
            isValidPasswordState = isValidPasswordState,
            isAuthorizeButtonEnabledState = isAuthorizeButtonEnabledState,
            isRegisterButtonEnabledState = isRegisterButtonEnabledState
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
    phoneTextState: MutableState<TextFieldValue>,
    passwordTextState: MutableState<TextFieldValue>,
    firstNameTextState: MutableState<TextFieldValue>,
    lastNameTextState: MutableState<TextFieldValue>,
    isValidPhoneState: MutableState<Boolean>,
    isValidPasswordState: MutableState<Boolean>,
    isValidFirstNameState: MutableState<Boolean>,
    isValidLastNameState: MutableState<Boolean>,
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
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 12.dp)
        ) {
            CustomNameField(
                textState = firstNameTextState,
                placeholder = resources.getString(R.string.first_name),
                modifier = Modifier
                    .fillMaxWidth(),
                isValidState = isValidFirstNameState
            )
            CustomNameField(
                textState = lastNameTextState,
                placeholder = resources.getString(R.string.last_name),
                modifier = Modifier
                    .fillMaxWidth(),
                isValidState = isValidLastNameState
            )
            CustomPhoneField(
                textState = phoneTextState,
                placeholder = resources.getString(R.string.phone_number),
                modifier = Modifier
                    .fillMaxWidth(),
                isValidState = isValidPhoneState
            )
            CustomPasswordField(
                textState = passwordTextState,
                placeholder = resources.getString(R.string.password),
                modifier = Modifier
                    .fillMaxWidth(),
                isValidState = isValidPasswordState
            )
        }

    }
}

@Composable
private fun SetBottomContent(
    context: Context,
    navController: NavController,
    isValidPhoneState: MutableState<Boolean>,
    isValidPasswordState: MutableState<Boolean>,
    isRegisterButtonEnabledState: MutableState<Boolean>,
    isAuthorizeButtonEnabledState: MutableState<Boolean>
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ButtonInCenter(
            buttonText = context.resources.getString(R.string.registration),
            bottomPadding = 12.dp
        ) {
            if (!isValidPhoneState.value) Toast.makeText(
                context,
                "Телефон!",
                Toast.LENGTH_SHORT
            ).show()
            if (!isValidPasswordState.value) Toast.makeText(
                context,
                "Пароль!",
                Toast.LENGTH_SHORT
            ).show()
        }
        ButtonInCenter(
            modifier = Modifier.navigationBarsPadding(),
            buttonText = context.resources.getString(R.string.enter_with_account),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Yellow
            ),
            isButtonEnabled = isAuthorizeButtonEnabledState
        ) {
            isAuthorizeButtonEnabledState.value = false
            navController.popBackStack()
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