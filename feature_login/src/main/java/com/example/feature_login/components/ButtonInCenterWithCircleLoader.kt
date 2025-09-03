package com.example.feature_login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.components.ButtonInCenter
import com.example.ui.components.IndeterminateCircularIndicator
import com.example.ui.components.defaultButtonContainerColor
import com.example.ui.components.defaultButtonContentColor
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.Yellow

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
        contentColor = defaultButtonContentColor,
        disabledContentColor = defaultButtonContainerColor,
        containerColor = defaultButtonContainerColor,
        disabledContainerColor = defaultButtonContainerColor
    ),
    loaderColor: Color = defaultButtonContainerColor, loaderTrackColor: Color = Yellow,
    isLoading: Boolean = false,
    onClick: () -> Unit
) {
    Box {
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
        ButtonInCenterWithCircleLoader(buttonText = "Button") {}
    }
}