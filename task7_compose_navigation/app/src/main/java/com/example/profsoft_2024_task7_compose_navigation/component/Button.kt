package com.example.profsoft_2024_task7_compose_navigation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

@Composable
fun SetButton(
    buttonText: String, modifier: Modifier = Modifier, func: () -> Unit
) {
    Button(
        onClick = { func() },
        shape = RoundedCornerShape(size = 12.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
        )
    ) {
        Text(text = buttonText, style = Typography.bodyLarge)
    }
}

@Composable
fun SetButtonInCenter(
    buttonText: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        .height(56.dp), func: () -> Unit
) {
    SetButton(buttonText = buttonText, modifier = modifier) {
        func()
    }
}

@Preview
@Composable
fun previewButton(){
    SetButtonInCenter("Button"){}
}