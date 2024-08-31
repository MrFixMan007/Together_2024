package com.example.ui.components.bottom_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ui.theme.ComposeTheme
import com.example.ui.theme.Gray215

@Composable
fun BottomBarScreen(navController: NavController) {
    val screens = listOf(
        BottomBarRoot.Home,
        BottomBarRoot.Favourites,
        BottomBarRoot.Add,
        BottomBarRoot.Message,
        BottomBarRoot.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Column {
        HorizontalDivider(thickness = 1.dp, color = Gray215)
        NavigationBar(
            containerColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier.height(56.dp)
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }


}

@Composable
fun RowScope.AddItem(
    screen: BottomBarRoot,
    currentDestination: NavDestination?,
    navController: NavController
) {
    NavigationBarItem(
        icon = {
            Icon(
                modifier = Modifier.height(20.dp),
                imageVector = ImageVector.vectorResource(id = screen.icon),
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors()
            .copy(selectedIndicatorColor = Gray215.copy(alpha = 0.5f)),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Composable
@Preview
private fun Preview() {
    ComposeTheme {
        Scaffold(bottomBar = {
            BottomBarScreen(rememberNavController())
        }) { paddingValues ->
            Text(
                text = "hello", modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    }

}