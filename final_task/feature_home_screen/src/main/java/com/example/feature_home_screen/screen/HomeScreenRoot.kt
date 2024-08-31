package com.example.feature_home_screen.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.feature_home_screen.screen.model.HomeSideNavigate
import com.example.feature_home_screen.screen.viewmodel.HomeViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun HomeScreenRoot(
    navController: NavController,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val sideEffects = viewModel.sideNavigate

    LaunchedEffect(sideEffects) {
        sideEffects.collect { navigateEffect ->
            when (navigateEffect) {
                is HomeSideNavigate.NavigateToAllCourses -> {}
                is HomeSideNavigate.NavigateToAllLocalNotes -> {}
                is HomeSideNavigate.NavigateToAllCommunityNotes -> {}

                else -> Unit
            }
        }
    }

    HomeScreenContent(
        state = viewModel.collectAsState().value,
        sideEffects = viewModel.container.sideEffectFlow
    ) {

    }
}