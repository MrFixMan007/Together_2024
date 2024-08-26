package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.feature_main_screen.navigation.mainScreen
import com.example.ui.components.bottom_bar.BottomBarRoot

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarRoot.Home.route
    ) {
        mainScreen(navController = navController)
//        composable(route = BottomBarRoot.Favourites.route) {
////            ProfileScreen()
//        }
//        composable(route = BottomBarRoot.Add.route) {
////            ProfileScreen()
//        }
//        composable(route = BottomBarRoot.Message.route) {
////            ProfileScreen()
//        }
//        composable(route = BottomBarRoot.Profile.route) {
////            ProfileScreen()
//        }
    }
}