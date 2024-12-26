package com.example.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartlab.ui.screens.AutorizationScreen
import com.example.smartlab.ui.screens.MainScreen
import com.example.smartlab.ui.screens.SplashScreen
import com.example.smartlab.ui.screens.WelcomePager
import com.example.smartlab.ui.theme.SmartLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(color = Color.White, modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        NavigationScreens()
                    }
                }
            }
        }
    }
}
@Composable
fun NavigationScreens() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("welcome_pager") {
            WelcomePager(navController = navController)
        }
        composable("autorization_screen") {
            AutorizationScreen(navController = navController, index = 0)
        }
        composable("main_screen") {
            MainScreen()
        }
    }
}
