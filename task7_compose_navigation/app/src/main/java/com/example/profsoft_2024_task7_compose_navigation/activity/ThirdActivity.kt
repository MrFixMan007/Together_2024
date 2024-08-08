package com.example.profsoft_2024_task7_compose_navigation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.ActionBar
import com.example.profsoft_2024_task7_compose_navigation.component.SetButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetThirdPage(
                title = resources.getString(R.string.changes_profile),
                buttonText = resources.getString(R.string.save)
            )
        }
    }
}

@Composable
private fun SetThirdPage(title: String, buttonText: String) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            ActionBar(title = title) {}
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
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            SetButtonInCenter(
                buttonText = buttonText
            ) {
                //TODO
            }
        }
    }
}

@Preview
@Composable
private fun PreviewThirdContent() {
    SetThirdPage(
        title = "Hello World!",
        buttonText = "Активити 2"
    )
}