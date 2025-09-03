package com.example.common.domain.model.authenticated

data class LocalNote(
    val id: String,
    val title: String,
    val date: String,
    val text: List<Text>,
)