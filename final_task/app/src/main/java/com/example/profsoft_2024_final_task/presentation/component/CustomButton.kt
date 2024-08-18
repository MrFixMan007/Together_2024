package com.example.profsoft_2024_final_task.presentation.component

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    isButtonEnabled: MutableState<Boolean>,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick()
            Log.e("CustomButton: ", isButtonEnabled.value.toString())},
        shape = shape,
        modifier = modifier,
        colors = colors,
        enabled = isButtonEnabled.value
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
    isButtonEnabled: MutableState<Boolean> = remember {
        mutableStateOf(true)
    },
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeTheme {
        ButtonInCenter(buttonText = "Button") {}
    }
}