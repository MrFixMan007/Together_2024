package com.example.feature_main_screen.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.feature_main_screen.screen.model.MainSideNavigate
import com.example.feature_main_screen.screen.viewmodel.MainViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreenRoot(
    navController: NavController,
) {
    val viewModel: MainViewModel = hiltViewModel()
    val sideEffects = viewModel.sideNavigate

    LaunchedEffect(sideEffects) {
        sideEffects.collect { navigateEffect ->
            when (navigateEffect) {
                is MainSideNavigate.NavigateToAllCourses -> {}
                is MainSideNavigate.NavigateToAllLocalNotes -> {}
                is MainSideNavigate.NavigateToAllCommunityNotes -> {}

                else-> Unit
            }
        }
    }

    MainScreenContent(state = viewModel.collectAsState().value, sideEffects = viewModel.container.sideEffectFlow) {

    }
}