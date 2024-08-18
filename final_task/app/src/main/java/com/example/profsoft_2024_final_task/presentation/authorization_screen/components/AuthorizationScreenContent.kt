package com.example.profsoft_2024_final_task.presentation.authorization_screen.components

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
import com.example.profsoft_2024_final_task.presentation.component.CustomPasswordField
import com.example.profsoft_2024_final_task.presentation.component.CustomPhoneField
import com.example.profsoft_2024_final_task.presentation.navigation.navigateToRegistrationScreen
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Typography
import com.example.profsoft_2024_final_task.presentation.theme.Yellow
import kotlinx.coroutines.delay

@Composable
fun AuthorizationScreenContent(navController: NavController) {
    val context = LocalContext.current
    val phoneTextState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordTextState = remember { mutableStateOf(TextFieldValue("")) }
    val isValidPhoneState = remember { mutableStateOf(false) }
    val isValidPasswordState = remember { mutableStateOf(false) }

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
            isValidPhoneState = isValidPhoneState,
            isValidPasswordState = isValidPasswordState
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
    isValidPhoneState: MutableState<Boolean>,
    isValidPasswordState: MutableState<Boolean>,
) {
    Column(modifier = Modifier.padding(top = 70.dp, start = 16.dp, end = 16.dp)) {
        val resources = context.resources
        Text(text = resources.getString(R.string.entry), style = Typography.headlineLarge)
        Text(
            text = resources.getString(R.string.entry_description),
            style = Typography.bodyMedium,
            modifier = Modifier.padding(top = 6.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 12.dp)
        ) {
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
            buttonText = context.resources.getString(R.string.enter),
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
            buttonText = context.resources.getString(R.string.registration),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Yellow
            ),
            isButtonEnabled = isRegisterButtonEnabledState
        ) {
//            isButtonEnabled.value = false
            navController.navigateToRegistrationScreen()
        }
    }
}

@Preview
@Composable
private fun PreviewMainContent() {
    ComposeTheme {
        AuthorizationScreenContent(rememberNavController())
    }
}