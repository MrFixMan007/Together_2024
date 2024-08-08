package com.example.profsoft_2024_task7_compose_navigation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.ActionBar
import com.example.profsoft_2024_task7_compose_navigation.component.SetButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.navigation.NavHost
import com.example.profsoft_2024_task7_compose_navigation.navigation.SECOND_SCREEN_ROUTE
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ComposeTheme{
//                SetMainPage(
//                    title = resources.getString(R.string.main_activity_title),
//                    buttonText = resources.getString(R.string.profile)
//                )
                NavHost(navController = navController, startDestination = SECOND_SCREEN_ROUTE)
            }

        }
    }
}

@Composable
private fun SetMainPage(title: String, buttonText: String) {
        ActionBar(title = title) {}
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

@Preview
@Composable
private fun PreviewMainContent() {
    SetMainPage(
        title = "Hello World!",
        buttonText = "Активити 2"
    )
}