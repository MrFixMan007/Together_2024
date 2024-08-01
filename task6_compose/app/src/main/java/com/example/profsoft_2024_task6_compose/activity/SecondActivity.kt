package com.example.profsoft_2024_task6_compose.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task6_compose.R
import com.example.profsoft_2024_task6_compose.component.MyButtonObject
import com.example.profsoft_2024_task6_compose.theme.ComposeTheme
import com.example.profsoft_2024_task6_compose.theme.Red

class SecondActivity : AppCompatActivity() {
    private lateinit var extra: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetPage(
                extra = extra,
                buttonText = resources.getString(R.string.second_activity_button_label)
            )
        }
        extra = intent.extras?.getString(EXTRA_KEY).orEmpty()
    }
}

@Composable
fun SetPage(extra: String, buttonText: String) {
    ComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val context = LocalContext.current

            Box(
                modifier = Modifier
                    .padding(50.dp)
                    .fillMaxWidth()
                    .height(112.dp)
                    .background(
                        color = Red,
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            bottomEnd = 32.dp
                        )
                    )
            )

            SetMiddlePicture()
            MyButtonObject.SetButton(
                buttonText = buttonText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp)
                    .height(50.dp)
            ) {
                Toast.makeText(context, extra, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun SetMiddlePicture() {
    Image(
        painter = painterResource(id = R.drawable.image),
        contentScale = ContentScale.FillWidth,
        contentDescription = stringResource(id = R.string.content_description),
        modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .fillMaxWidth()
            .height(242.dp)
    )
}

@Preview
@Composable
fun PreviewPage() {
    SetPage("test", "Уведомление")
}