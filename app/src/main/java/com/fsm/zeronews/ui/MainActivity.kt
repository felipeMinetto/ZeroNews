package com.fsm.zeronews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fsm.zeronews.ArticlesScreen
import com.fsm.zeronews.SourcesScreen
import com.fsm.zeronews.ui.theme.ZeroNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ZeroNewsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = Screen.Sources.route) {
                        composable(Screen.Sources.route) { SourcesScreen(navController = navController) }
                        composable(Screen.Articles.route) { ArticlesScreen(navController = navController) }
                    }
                }
            }
        }
    }
}