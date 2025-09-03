package com.example.together.app.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation_authenticated.MAIN_SCREEN_ROUTE
import com.example.navigation_unauthenticated.UnauthenticatedNavigation
import com.example.together.presentation.navigation.MyNavHost
import com.example.ui.theme.ComposeTheme
import com.example.utils.TOKEN_NAME
import com.example.utils.TOKEN_SHARED_PREFS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(TOKEN_SHARED_PREFS, MODE_PRIVATE)
        val myToken = sharedPreferences.getString(TOKEN_NAME, "").toString()
        val startDestination =
            if (myToken.isEmpty()) UnauthenticatedNavigation.AUTHORIZATION_ROUTE else MAIN_SCREEN_ROUTE

        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()

            ComposeTheme {
                MyNavHost(
                    navController = navController,
                    startDestination = startDestination
                )
            }
        }
    }
}