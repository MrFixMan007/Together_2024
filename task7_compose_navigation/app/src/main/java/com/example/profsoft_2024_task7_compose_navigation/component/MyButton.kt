package com.example.profsoft_2024_task7_compose_navigation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

@Composable
fun SetButton(
    buttonText: String, modifier: Modifier = Modifier, func: () -> Unit
) {
    Button(
        onClick = { func() },
        shape = RoundedCornerShape(size = 12.dp),
        modifier = modifier
    ) {
        Text(text = buttonText, style = Typography.bodyMedium)
    }
}