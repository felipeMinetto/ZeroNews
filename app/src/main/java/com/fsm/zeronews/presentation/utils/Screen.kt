package com.fsm.zeronews.presentation.utils

sealed class Screen(val route: String) {
    object Sources : Screen("sources")
    object Articles : Screen("articles/{source}")
}
