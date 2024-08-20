package com.example.profsoft_2024_final_task.app.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_final_task.R
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.Yellow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            SplashScreenContent {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}

@Composable
private fun SplashScreenContent(onTimeout: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }

    val resources = LocalContext.current.resources
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow)

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = resources.getString(R.string.content_description),
            modifier = Modifier.align(Alignment.Center).size(128.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.text_logo),
            contentDescription = resources.getString(R.string.content_description),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
                .navigationBarsPadding()
        )
    }
}

@Composable
@Preview
private fun Preview() {
    ComposeTheme {
        SplashScreenContent {}
    }
}