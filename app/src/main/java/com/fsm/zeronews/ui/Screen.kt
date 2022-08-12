package com.fsm.zeronews.ui

sealed class Screen(val route: String) {
    object Sources : Screen("sources")
    object Articles : Screen("articles")
}
