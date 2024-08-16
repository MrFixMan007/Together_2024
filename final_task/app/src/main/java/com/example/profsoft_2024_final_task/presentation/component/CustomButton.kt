package com.example.profsoft_2024_final_task.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_final_task.presentation.theme.ComposeTheme
import com.example.profsoft_2024_final_task.presentation.theme.DarkGray
import com.example.profsoft_2024_final_task.presentation.theme.Typography

private val defaultContentColor = Color.White
private val defaultContainerColor = DarkGray

@Composable
fun CustomButton(
    buttonText: String, modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = defaultContentColor,
        containerColor = defaultContainerColor
    ),
    shape: Shape = RoundedCornerShape(size = 8.dp),
    textStyle: TextStyle = Typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = shape,
        modifier = modifier,
        colors = colors
    ) {
        Text(
            text = buttonText,
            style = textStyle
        )
    }
}

@Composable
fun ButtonInCenter(
    buttonText: String,
    sidePadding: Dp = 16.dp, topPadding: Dp = 0.dp, bottomPadding: Dp = 16.dp,
    height: Dp = 40.dp,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = defaultContentColor,
        containerColor = defaultContainerColor
    ),
    onClick: () -> Unit
) {
    CustomButton(
        buttonText = buttonText, modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = sidePadding,
                end = sidePadding,
                bottom = bottomPadding,
                top = topPadding
            )
            .height(height), colors = colors,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
fun previewButton() {
    ComposeTheme {
        ButtonInCenter("Button") {}
    }
}