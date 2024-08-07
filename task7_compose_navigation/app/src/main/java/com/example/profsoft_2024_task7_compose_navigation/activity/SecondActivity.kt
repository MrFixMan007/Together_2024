package com.example.profsoft_2024_task7_compose_navigation.activity

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
import com.example.profsoft_2024_task7_compose_navigation.R
import com.example.profsoft_2024_task7_compose_navigation.component.SetActionBar
import com.example.profsoft_2024_task7_compose_navigation.component.SetButton
import com.example.profsoft_2024_task7_compose_navigation.theme.ComposeTheme
import com.example.profsoft_2024_task7_compose_navigation.theme.Red

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SetPage(
                buttonText = resources.getString(R.string.profile)
            )
        }
    }
}

@Composable
fun SetPage(buttonText: String) {
    ComposeTheme {
        SetActionBar(title = "Пшеше", haveBackArrow = true) {
            
        }
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
            SetButton(
                buttonText = buttonText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp)
                    .height(50.dp)
            ) {
                Toast.makeText(context, "нажал", Toast.LENGTH_SHORT).show()
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
    SetPage("test")
}