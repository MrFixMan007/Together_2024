package com.example.feature_details.screen.community_note_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.feature_details.viewmodel.CommunityNoteViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CommunityNoteScreenRoot(
    navController: NavController,
    id: String
) {
    val viewModel: CommunityNoteViewModel = hiltViewModel()

    CommunityNoteScreenContent(
        state = viewModel.collectAsState().value,
        stack = navController.currentBackStackEntryAsState(),
        id = id,
        onAction = { action -> viewModel.onAction(action) }
    )
}