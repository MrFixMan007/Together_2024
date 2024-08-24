package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.components.model.NoteCommonInfo
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.DarkGray
import com.example.ui.theme.LightBrown
import com.example.ui.theme.Typography
import com.example.ui.theme.Yellow

@Composable
fun CustomSimpleNote(
    modifier: Modifier,
    textModifier: Modifier = Modifier.padding(12.dp),
    noteInfo: NoteCommonInfo,
) {
    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .fillMaxHeight(),
            colors = CardDefaults.cardColors(containerColor = Yellow),
            shape = RoundedCornerShape(
                topStart = 8.dp,
                topEnd = 0.dp,
                bottomEnd = 8.dp,
                bottomStart = 8.dp
            )
        ) {
            Column(modifier = textModifier) {
                Text(
                    text = noteInfo.title,
                    style = Typography.headlineMedium,
                    modifier = Modifier.padding(end = 76.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = noteInfo.description,
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                    color = LightBrown,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Box(
            modifier = Modifier
                .height(30.dp)
                .align(Alignment.TopEnd)
                .background(DarkGray, RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = noteInfo.date,
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    ComposeTheme {
        CustomSimpleNote(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp),
            noteInfo = NoteCommonInfo(
                title = "Для создания новой Activity. Тест для нескольких строк",
                description = "Нужно лишь применить старый дедовский визард. Да",
                date = "12 июля"
            )
        )
    }
}