package com.fsm.zeronews.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fsm.zeronews.presentation.ui.articles.ArticlesScreen
import com.fsm.zeronews.presentation.ui.sources.SourcesScreen
import com.fsm.zeronews.presentation.ui.sources.SourcesViewModel
import com.fsm.zeronews.presentation.ui.theme.ZeroNewsTheme
import com.fsm.zeronews.presentation.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ZeroNewsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = Screen.Sources.route) {
                        composable(Screen.Sources.route) {
                            val viewModel = hiltViewModel<SourcesViewModel>()
                            SourcesScreen(navController = navController, viewModel)
                        }
                        composable(Screen.Articles.route) { ArticlesScreen() }
                    }
                }
            }
        }
    }
}