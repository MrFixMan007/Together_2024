package com.example.profsoft_2024_task7_compose_navigation.thirdscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.ButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

@Composable
fun ThirdScreenContent(navController: NavController) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "${stringResource(id = R.string.first_name)}: ${stringResource(id = R.string.first_name_value)}",
                    style = Typography.titleMedium
                )
                Text(
                    text = "${stringResource(id = R.string.last_name)}: ${stringResource(id = R.string.last_name_value)}",
                    style = Typography.titleMedium
                )
                Text(
                    text = "${stringResource(id = R.string.patronymic)}: ${stringResource(id = R.string.patronymic_value)}",
                    style = Typography.titleMedium
                )
                Text(
                    text = "${stringResource(id = R.string.date_of_birth)}: ${stringResource(id = R.string.date_of_birth_value)}",
                    style = Typography.titleMedium
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                ButtonInCenter(
                    buttonText = LocalContext.current.resources.getString(R.string.save),
                    onClick = navController::popBackStack
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewThirdContent() {
    ThirdScreenContent(rememberNavController())
}