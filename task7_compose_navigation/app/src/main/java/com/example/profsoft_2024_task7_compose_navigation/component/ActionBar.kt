package com.example.profsoft_2024_task7_compose_navigation.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profsoft_2024_task7_compose_navigation.theme.Typography

@Composable
fun SetActionBar(
    title: String,
    haveBackArrow: Boolean = false,
    containerColor: Color = Color.White,
    backArrowPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = containerColor),
        verticalArrangement = Arrangement.Top,
    ) {
        if (haveBackArrow) ArrowWithText(title) { backArrowPressed() }
        else {
            Text(
                text = title,
                style = Typography.titleLarge,
                modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 16.dp).height(24.dp)
            )
        }
        DrawLine()
    }
}

@Composable
fun ArrowWithText(title: String, backArrowPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clickable { backArrowPressed() },
            contentAlignment = Alignment.Center
        ) {
            DrawArrow(
                modifier = Modifier
                    .size(14.dp, 14.dp),
            )
        }
        Text(
            text = title,
            style = Typography.titleLarge,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}

@Composable
fun DrawArrow(modifier: Modifier) {
    Canvas(modifier = modifier) {
        val path = Path().apply {
            moveTo(size.width * 0.5f, 0f)
            lineTo(0f, size.height * 0.5f)
            lineTo(size.width * 0.5f, size.height)
            moveTo(0f, size.height * 0.5f)
            lineTo(size.width, size.height * 0.5f)
        }
        drawPath(
            path = path,
            color = Color.Black,
            style = Stroke(width = 4f)
        )
    }
}

@Composable
fun DrawLine(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    Canvas(
        modifier = modifier
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            strokeWidth = 4f,
            cap = StrokeCap.Square
        )
    }
}

@Preview
@Composable
fun preview() {
//    DrawArrow()
    SetActionBar(title = "Title Head", haveBackArrow = false) {}
}