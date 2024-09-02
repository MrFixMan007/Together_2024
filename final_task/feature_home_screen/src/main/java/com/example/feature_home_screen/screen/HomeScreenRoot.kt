package com.example.feature_home_screen.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.feature_home_screen.screen.model.HomeSideNavigate
import com.example.feature_home_screen.screen.viewmodel.HomeViewModel
import com.example.navigation_unauthenticated.UnauthenticatedNavigation
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
                is HomeSideNavigate.NavigateToAuthorize -> navController.navigate(
                    UnauthenticatedNavigation.AUTHORIZATION_ROUTE
                )
            }
        }
    }

    HomeScreenContent(
        state = viewModel.collectAsState().value,
        sideEffects = viewModel.container.sideEffectFlow,
        stack = navController.currentBackStackEntryAsState(),
        onAction = { action -> viewModel.onAction(action) }
    )
}