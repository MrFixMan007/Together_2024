package com.example.profsoft_2024_final_task.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.profsoft_2024_final_task.presentation.theme.Yellow

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
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = shape,
        modifier = modifier,
        colors = colors,
        enabled = isButtonEnabled
    ) {
        Text(
            text = buttonText,
            style = textStyle
        )
    }
}

@Composable
fun ButtonInCenter(
    modifier: Modifier = Modifier,
    buttonText: String,
    sidePadding: Dp = 16.dp, topPadding: Dp = 0.dp, bottomPadding: Dp = 16.dp,
    height: Dp = 40.dp,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = defaultContentColor,
        containerColor = defaultContainerColor
    ),
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit
) {
    CustomButton(
        buttonText = buttonText, modifier = modifier
            .fillMaxWidth()
            .padding(
                start = sidePadding,
                end = sidePadding,
                bottom = bottomPadding,
                top = topPadding
            )
            .height(height), colors = colors,
        isButtonEnabled = isButtonEnabled,
        onClick = onClick
    )
}

@Composable
fun ButtonInCenterWithCircleLoader(
    modifier: Modifier = Modifier,
    loaderModifier: Modifier = Modifier
        .size(32.dp)
        .padding(top = 4.dp),
    buttonText: String,
    sidePadding: Dp = 16.dp, topPadding: Dp = 0.dp, bottomPadding: Dp = 16.dp,
    height: Dp = 40.dp,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = defaultContentColor,
        disabledContentColor = defaultContainerColor,
        containerColor = defaultContainerColor,
        disabledContainerColor = defaultContainerColor
    ),
    loaderColor: Color = defaultContainerColor, loaderTrackColor: Color = Yellow,
    isLoading: Boolean = false,
    onClick: () -> Unit
) {
    Box{
        ButtonInCenter(
            modifier = modifier,
            buttonText = buttonText,
            sidePadding = sidePadding,
            topPadding = topPadding,
            bottomPadding = bottomPadding,
            height = height,
            colors = buttonColors,
            isButtonEnabled = !isLoading,
            onClick = onClick
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            IndeterminateCircularIndicator(
                modifier = loaderModifier,
                loadingState = isLoading,
                color = loaderColor,
                trackColor = loaderTrackColor
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeTheme {
        ButtonInCenterWithCircleLoader(buttonText = "Button", isLoading = true) {}
    }
}