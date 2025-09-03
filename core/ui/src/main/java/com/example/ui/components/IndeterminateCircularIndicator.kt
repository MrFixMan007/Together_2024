package com.example.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Yellow

@Composable
fun IndeterminateCircularIndicator(
    modifier: Modifier,
    loadingState: Boolean,
    color: Color, trackColor: Color
) {
    if (!loadingState) return

    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
    )
}

@Preview
@Composable
private fun Preview(){
    IndeterminateCircularIndicator(
        modifier = Modifier.size(64.dp),
        loadingState = true,
        color = Color.Black,
        trackColor = Yellow
    )
}