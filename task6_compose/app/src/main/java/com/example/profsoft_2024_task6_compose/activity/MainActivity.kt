package com.example.profsoft_2024_task6_compose.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task6_compose.R
import com.example.profsoft_2024_task6_compose.component.MyButtonObject
import com.example.profsoft_2024_task6_compose.theme.ComposeTheme
import com.example.profsoft_2024_task6_compose.theme.Typography

const val EXTRA_KEY = "extra_key"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetContentPage(
                textViewText = resources.getString(R.string.main_activity_text),
                buttonText = resources.getString(R.string.main_activity_button_label)
            )
        }
    }
}

@Composable
fun SetContentPage(textViewText: String, buttonText: String) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val context = LocalContext.current
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, context.getString(R.string.extra_message))
            }
            Text(
                text = textViewText, style = Typography.bodyMedium
            )

            MyButtonObject.SetButton(
                buttonText = buttonText, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .height(49.dp)
            ) {
                context.startActivity(intent)
            }
        }
    }
}

@Preview
@Composable
fun PreviewContent() {
    SetContentPage(
        textViewText = "Hello World!",
        buttonText = "Активити 2"
    )
}