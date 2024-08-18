package com.example.profsoft_2024_final_task.presentation.authorization_screen.components

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ButtonInCenter
import com.example.profsoft_2024_final_task.presentation.component.CustomPasswordField
import com.example.profsoft_2024_final_task.presentation.component.CustomPhoneField
import com.example.profsoft_2024_final_task.presentation.navigation.navigateToSecondScreen
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Typography
import com.example.profsoft_2024_final_task.presentation.theme.Yellow

@Composable
fun AuthorizationScreenContent(navController: NavController) {
    val resources = LocalContext.current.resources
    val context = LocalContext.current
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val textState1 = remember { mutableStateOf(TextFieldValue("")) }
    val isValidPhoneState = remember { mutableStateOf(false) }
    val isValidPasswordState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow),
    ) {
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

        Column(modifier = Modifier.padding(top = 70.dp, start = 16.dp, end = 16.dp)) {
            Text(text = resources.getString(R.string.entry), style = Typography.headlineLarge)
            Text(
                text = resources.getString(R.string.entry_description),
                style = Typography.bodyMedium,
                modifier = Modifier.padding(top = 6.dp)
            )
            CustomPhoneField(
                textState = textState,
                placeholder = resources.getString(R.string.phone_number),
                modifier = Modifier.padding(top = 12.dp).fillMaxWidth(),
                isValidState = isValidPhoneState
            )
            CustomPasswordField(
                textState = remember { mutableStateOf(TextFieldValue("")) },
                placeholder = resources.getString(R.string.password),
                modifier = Modifier.padding(top = 12.dp).fillMaxWidth(),
                isValidState = isValidPasswordState
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            ButtonInCenter(
                buttonText = resources.getString(R.string.enter),
                bottomPadding = 12.dp
            ) {
                if (!isValidPhoneState.value) Toast.makeText(context, "Телефон!", Toast.LENGTH_SHORT).show()
                if (!isValidPasswordState.value) Toast.makeText(context, "Пароль!", Toast.LENGTH_SHORT).show()
//                navController.navigateToSecondScreen(
//                    firstName = "Ivan",
//                    lastName = "Ivanov",
//                    patronymic = "Ivanovich",
//                    birthday = "01.01.2005"
//                )
            }
            ButtonInCenter(
                modifier = Modifier.navigationBarsPadding(),
                buttonText = resources.getString(R.string.registration),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Yellow
                )
            ) {
                navController.navigateToSecondScreen(
                    firstName = "Ivan",
                    lastName = "Ivanov",
                    patronymic = "Ivanovich",
                    birthday = "01.01.2005"
                )
            }
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