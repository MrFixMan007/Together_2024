package com.example.profsoft_2024_task6_compose.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task6_compose.theme.Typography

object MyButtonObject {
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
}