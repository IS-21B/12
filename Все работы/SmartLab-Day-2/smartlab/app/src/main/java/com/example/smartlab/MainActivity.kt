package com.example.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.companents.OnboardHeader
import com.example.smartlab.ui.layouts.Auth
import com.example.smartlab.ui.layouts.CodeEmail
import com.example.smartlab.ui.layouts.CreateUser
import com.example.smartlab.ui.layouts.Onboard
import com.example.smartlab.ui.layouts.PasswdApp
import com.example.smartlab.ui.theme.SmartLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            Onboard(modifier.fillMaxSize(),"Пропустить", "Анализы", "Экспресс сбор и получение проб", navController)
        }
        composable("auth"){
            Auth(Modifier, "Добро пожаловать!", "Войдите, чтобы пользоваться функциями приложения", navController)
        }
        composable("codeEmail") {
            CodeEmail(Modifier, navController)
        }
        composable("passwdApp") {
            PasswdApp(navController)
        }
        composable("createUser") {
            CreateUser(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartLabTheme {
        Main()
    }
}