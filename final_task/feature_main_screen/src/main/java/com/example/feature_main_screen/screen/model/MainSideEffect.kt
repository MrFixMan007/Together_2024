package com.example.feature_main_screen.screen.model

sealed class MainSideEffect{
    data object FailedLoad : MainSideEffect()
}