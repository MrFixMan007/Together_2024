package com.example.ui.components.custom_cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.components.model.CourseInfo
import com.example.ui.theme.Typography
import com.example.ui.theme.Yellow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomCourse(courseInfo: CourseInfo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Yellow),
        shape = RoundedCornerShape(size = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 12.dp
            )
        ) {
            Text(
                text = courseInfo.title,
                style = Typography.headlineLarge,
                modifier = Modifier.padding(end = 88.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(18.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                for (tag in courseInfo.tags) {
                    Chip(text = tag)
                }
            }
        }
    }
}

@Composable
fun Chip(text: String) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = Color.Transparent,
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Text(
            text = text,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            style = Typography.bodySmall.copy(fontWeight = FontWeight.W500)
        )
    }
}

@Composable
@Preview
private fun Preview() {
    CustomCourse(
        courseInfo = CourseInfo(
            title = "Основы Андроида",
            tags = listOf(
                "View",
                "Компоненты андроид",
                "Intent",
                "Kotlin",
                "Создание проекта",
                "Manifest",
            )
        ),
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}