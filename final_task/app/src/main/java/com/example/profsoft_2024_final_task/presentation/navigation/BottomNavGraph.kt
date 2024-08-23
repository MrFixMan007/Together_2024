package com.example.profsoft_2024_final_task.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.profsoft_2024_final_task.bottom_bar.BottomBarScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    androidx.navigation.compose.NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
//            HomeScreen()
        }
        composable(route = BottomBarScreen.Favourites.route) {
//            ProfileScreen()
        }
        composable(route = BottomBarScreen.Add.route) {
//            ProfileScreen()
        }
        composable(route = BottomBarScreen.Message.route) {
//            ProfileScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
//            ProfileScreen()
        }
    }
}