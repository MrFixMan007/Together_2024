package com.example.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.components.custom_cards.CustomCourse
import com.example.ui.components.model.CourseInfo
import com.example.ui.theme.Gray51
import com.example.ui.theme.Gray217

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomCoursePager(coursesInfo: List<CourseInfo>, modifier: Modifier) {
    val pagerState = rememberPagerState(pageCount = {
        coursesInfo.size
    })
    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            CustomCourse(
                courseInfo = coursesInfo[page],
                modifier = Modifier.height(160.dp)
            )
        }
        if (coursesInfo.size > 1) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Gray51 else Gray217
                    if (iteration > 0) {
                        Spacer(modifier = Modifier.width(2.dp))
                    }
                    Box(
                        modifier = Modifier
                            .background(color)
                            .weight(1f)
                            .height(2.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    CustomCoursePager(
        coursesInfo = listOf(
            CourseInfo(
                title = "Основы Андроида", tags = listOf(
                    "View",
                    "Компоненты андроид",
                    "Intent",
                    "Создание проекта",
                    "Manifest",
                )
            ),
            CourseInfo(title = "Язык программирования", tags = listOf("Kotlin")),
            CourseInfo(title = "Тесты", tags = listOf("JUnit Test")),
            CourseInfo(title = "Test", tags = listOf("Test")),
            CourseInfo(title = "Test", tags = listOf("Test")),
            CourseInfo(title = "Test", tags = listOf("Test")),
            CourseInfo(title = "Test", tags = listOf("Test")),
            CourseInfo(title = "Test", tags = listOf("Test")),
        ),
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}