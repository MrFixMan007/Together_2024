package com.example.ui.components.custom_cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.ui.R
import com.example.ui.components.model.NoteCommonInfo
import com.example.ui.components.model.NoteCommunityInfo
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.Gray51
import com.example.ui.theme.Typography

@Composable
fun CustomCommunityNote(
    modifier: Modifier,
    textModifier: Modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp),
    noteInfo: NoteCommunityInfo
) {
    Box(modifier = modifier) {
        CustomSimpleNote(
            noteInfo = noteInfo.noteCommonInfo,
            modifier = Modifier,
            textModifier = textModifier
        )

        if (!noteInfo.lastCommentatorFullName.isNullOrEmpty()) {
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .align(Alignment.TopStart)
                    .background(Gray51, RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp)
                    .widthIn(max = 200.dp),
                contentAlignment = Alignment.Center,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (!noteInfo.lastCommentatorIconUrl.isNullOrEmpty()) {
                        Image(
                            painter = rememberAsyncImagePainter(model = noteInfo.lastCommentatorIconUrl),
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape),
                            contentDescription = "Avatar",
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.round_person_14),
                            tint = Color.White,
                            modifier = Modifier.size(14.dp),
                            contentDescription = "Avatar"
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = noteInfo.lastCommentatorFullName,
                        style = Typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )
                }
            }
        }


    }

}

@Composable
@Preview
private fun Preview() {
    val noteInfo = NoteCommunityInfo(
        noteCommonInfo = NoteCommonInfo(
            title = "Для создания новой Activity. Тест для нескольких строк",
            description = "Нужно лишь применить старый дедовский визард. Да, всего лишь",
            date = "12 июля"
        ),
        lastCommentatorFullName = "Имя фамилия",
    )
    ComposeTheme {
        CustomCommunityNote(
            modifier = Modifier
                .fillMaxWidth()
                .height(124.dp)
                .padding(horizontal = 16.dp),
            noteInfo = noteInfo
        )
    }
}