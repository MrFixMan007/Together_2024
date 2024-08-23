package com.example.profsoft_2024_final_task.app.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.feature_login.navigation.AUTHORIZATION_SCREEN_ROUTE
import com.example.profsoft_2024_final_task.bottom_bar.BottomBar
import com.example.profsoft_2024_final_task.presentation.navigation.BottomNavGraph
import com.example.profsoft_2024_final_task.presentation.navigation.NavHost
import com.example.ui.theme.ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val extra = intent.extras?.getString(EXTRA_TOKEN).orEmpty()

            ComposeTheme {
                if (extra.isEmpty()) {
                    NavHost(
                        navController = navController,
                        startDestination = AUTHORIZATION_SCREEN_ROUTE
                    )
                } else {
                    Scaffold(bottomBar = { BottomBar(navController = navController) }) { paddingValues ->
                        BottomNavGraph(
                            navController = navController,
                            modifier = Modifier.padding(paddingValues)
                        )
                    }
                }
            }
        }
    }
}