package com.example.myapplication.UIs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maboutique.ui.screens.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {

                composable("home") {
                    HomePage(navController)
                }

                composable("login") {
                    LoginScreen(navController)
                }
            }
        }
    }
}