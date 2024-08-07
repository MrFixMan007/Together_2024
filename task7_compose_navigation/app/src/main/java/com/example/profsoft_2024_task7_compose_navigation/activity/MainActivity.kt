package com.example.profsoft_2024_task7_compose_navigation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.SetActionBar
import com.example.profsoft_2024_task7_compose_navigation.component.SetButtonInCenter
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetMainPage(
                title = resources.getString(R.string.main_activity_title),
                buttonText = resources.getString(R.string.profile)
            )
        }
    }
}

@Composable
fun SetMainPage(title: String, buttonText: String) {
    ComposeTheme {
        SetActionBar(title = title) {}
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            val context = LocalContext.current
            val intent = Intent(context, SecondActivity::class.java)
            SetButtonInCenter(
                buttonText = buttonText
            ) {
                context.startActivity(intent)
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainContent() {
    SetMainPage(
        title = "Hello World!",
        buttonText = "Активити 2"
    )
}