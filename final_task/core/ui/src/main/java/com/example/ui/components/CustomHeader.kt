package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Gray100
import com.example.ui.theme.Gray215
import com.example.ui.theme.Typography

@Composable
fun CustomHeader(
    title: String,
    clickText: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors().copy(containerColor = Gray215),
            shape = RoundedCornerShape(
                topStart = 8.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp,
                bottomStart = 8.dp
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                text = title,
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color.Black
            )
        }

        Card(
            colors = CardDefaults.cardColors().copy(containerColor = Gray215),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 8.dp,
                bottomEnd = 8.dp,
                bottomStart = 0.dp
            ),
            modifier = Modifier.clickable { onClick() }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                text = clickText,
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = Gray100
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    CustomHeader(
        title = "Ваши курсы",
        clickText = "Все",
        onClick = {},
        modifier = Modifier
            .padding()
            .fillMaxWidth()
    )
}