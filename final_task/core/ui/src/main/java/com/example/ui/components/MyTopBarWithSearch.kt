package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Gray51
import com.example.ui.theme.Typography
import com.example.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarWithSearch(title: String, onSearchClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title, style = Typography.headlineSmall, color = Color.Black)
        },
        actions = {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(
                        color = Gray51.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { onSearchClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
//                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    tint = Gray51
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Yellow)
    )
}

@Composable
@Preview
private fun Preview() {
    MyTopBarWithSearch(title = "Главная", onSearchClick = {})
}