package com.example.profsoft_2024_final_task.presentation.secondscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.component.ButtonInCenter
import com.example.profsoft_2024_final_task.presentation.navigation.navigateToThirdScreen
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.DarkGray
import com.example.profsoft_2024_final_task.presentation.theme.LightGray
import com.example.profsoft_2024_final_task.presentation.theme.Typography

private const val FIRST_NAME_KEY = "first_name_key"
private const val LAST_NAME_KEY = "last_name_key"
private const val PATRONYMIC_KEY = "patronymic_key"
private const val BIRTHDAY_KEY = "birthday_key"

@Composable
fun SecondScreenContent(
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
        )
        {
            val firstNameState = navController.currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<String>(FIRST_NAME_KEY)?.observeAsState()
            val lastNameState = navController.currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<String>(LAST_NAME_KEY)?.observeAsState()
            val patronymicState = navController.currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<String>(PATRONYMIC_KEY)?.observeAsState()
            val birthdayState = navController.currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<String>(BIRTHDAY_KEY)?.observeAsState()

            Row(
                modifier = Modifier
                    .height(120.dp)
                    .background(color = LightGray)
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = stringResource(id = R.string.content_description),
                    Modifier.padding(vertical = 8.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = firstNameState?.value ?: firstName,
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = lastNameState?.value ?: lastName,
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = patronymicState?.value ?: patronymic,
                                style = Typography.bodyMedium
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "${stringResource(id = R.string.date_of_birth)}:",
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = birthdayState?.value ?: birthday,
                                style = Typography.bodyMedium
                            )
                        }
                    }
                }
            }
            Text(
                text = stringResource(id = R.string.city),
                style = Typography.bodyLarge,
                color = DarkGray,
                modifier = Modifier.padding(start = 16.dp, top = 24.dp)
            )
            Text(
                text = stringResource(id = R.string.city_value),
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.about_myself),
                style = Typography.bodyLarge,
                color = DarkGray,
                modifier = Modifier.padding(start = 16.dp, top = 20.dp)
            )
            Text(
                text = stringResource(id = R.string.about_myself_value),
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                ButtonInCenter(
                    buttonText = LocalContext.current.resources.getString(R.string.change_profile)
                ) {
                    navController.navigateToThirdScreen(
                        firstName = firstNameState?.value ?: firstName,
                        lastName = lastNameState?.value ?: lastName,
                        patronymic = patronymicState?.value ?: patronymic,
                        birthday = birthdayState?.value ?: birthday,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSecondPage() {
    SecondScreenContent(
        rememberNavController(),
        firstName = "Иван",
        lastName = "Иванов",
        patronymic = "Иванович",
        birthday = "01.01.2001"
    )
}