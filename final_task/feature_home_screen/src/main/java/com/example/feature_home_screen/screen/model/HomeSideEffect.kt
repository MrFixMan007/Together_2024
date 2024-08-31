package com.example.feature_home_screen.screen.model

sealed class HomeSideEffect{
    data object FailedLoad : HomeSideEffect()
}