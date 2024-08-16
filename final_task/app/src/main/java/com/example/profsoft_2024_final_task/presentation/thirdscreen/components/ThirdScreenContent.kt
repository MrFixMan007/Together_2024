package com.example.profsoft_2024_final_task.presentation.thirdscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ButtonInCenter
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Typography

private const val FIRST_NAME_KEY = "first_name_key"
private const val LAST_NAME_KEY = "last_name_key"
private const val PATRONYMIC_KEY = "patronymic_key"
private const val BIRTHDAY_KEY = "birthday_key"

@Composable
fun ThirdScreenContent(
    navController: NavController,
    firstName: String,
    lastName: String,
    patronymic: String,
    birthday: String,
) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            val firstNameState = remember { mutableStateOf(firstName) }
            val lastNameState = remember { mutableStateOf(lastName) }
            val patronymicState = remember { mutableStateOf(patronymic) }
            val birthdayState = remember { mutableStateOf(birthday) }

            Column(
                modifier = Modifier.padding(start = 16.dp, top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row {
                    Text(
                        text = "${stringResource(id = R.string.first_name)}: ",
                        style = Typography.titleMedium
                    )
                    BasicTextFieldSample(
                        textState = firstNameState
                    )
                }
                Row {
                    Text(
                        text = "${stringResource(id = R.string.last_name)}: ",
                        style = Typography.titleMedium
                    )
                    BasicTextFieldSample(
                        textState = lastNameState
                    )
                }
                Row {
                    Text(
                        text = "${stringResource(id = R.string.patronymic)}: ",
                        style = Typography.titleMedium
                    )
                    BasicTextFieldSample(
                        textState = patronymicState
                    )
                }
                Row {
                    Text(
                        text = "${stringResource(id = R.string.date_of_birth)}: ",
                        style = Typography.titleMedium
                    )
                    DateTextFieldSample(textState = birthdayState)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                ButtonInCenter(
                    buttonText = LocalContext.current.resources.getString(R.string.save),
                    onClick = {
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            FIRST_NAME_KEY,
                            firstNameState.value
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            LAST_NAME_KEY,
                            lastNameState.value
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            PATRONYMIC_KEY,
                            patronymicState.value
                        )
                        navController.previousBackStackEntry?.savedStateHandle?.set(
                            BIRTHDAY_KEY,
                            birthdayState.value
                        )
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Composable
fun BasicTextFieldSample(textState: MutableState<String>) {
    BasicTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        textStyle = Typography.titleMedium,
    )
}

@Composable
fun DateTextFieldSample(textState: MutableState<String>) {
    BasicTextField(
        value = textState.value,
        onValueChange = {
            if (it.length <= 10) {
                val filteredText = it.filter { char -> char.isDigit() || char == '.' }
                textState.value = filteredText
            }
        },
        textStyle = Typography.titleMedium,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview
@Composable
private fun PreviewThirdContent() {
    ThirdScreenContent(
        navController = rememberNavController(),
        firstName = "Ivanyz",
        lastName = "Alexandrov",
        patronymic = "Ivanovich",
        birthday = "10.10.2010"
    )
}