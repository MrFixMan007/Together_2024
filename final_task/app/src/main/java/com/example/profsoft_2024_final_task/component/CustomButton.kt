package com.example.profsoft_2024_final_task.component

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
import com.example.profsoft_2024_final_task.theme.Typography

@Composable
fun CustomButton(
    buttonText: String, modifier: Modifier = Modifier, onClick: () -> Unit
) {
    Button(
        onClick = onClick,
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
fun ButtonInCenter(
    buttonText: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        .height(56.dp), onClick: () -> Unit
) {
    CustomButton(buttonText = buttonText, modifier = modifier, onClick = onClick)
}

@Preview
@Composable
fun previewButton() {
    ButtonInCenter("Button") {}
}