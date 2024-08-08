package com.example.profsoft_2024_task7_compose_navigation.secondscreen.components

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
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.ButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.navigation.navigateToThirdScreen
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme
import com.example.profsoft_2024_task7_compose_navigation.theme.DarkGray
import com.example.profsoft_2024_task7_compose_navigation.theme.LightGray
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

@Composable
fun SecondScreenContent(navController: NavController) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        )
        {
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
                                text = stringResource(id = R.string.first_name_value),
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = stringResource(id = R.string.last_name_value),
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = stringResource(id = R.string.patronymic_value),
                                style = Typography.bodyMedium
                            )
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = "${stringResource(id = R.string.date_of_birth)}:",
                                style = Typography.bodyMedium
                            )
                            Text(
                                text = stringResource(id = R.string.date_of_birth_value),
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
                    navController.navigateToThirdScreen()
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSecondPage() {
    SecondScreenContent(rememberNavController())
}