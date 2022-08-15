package com.fsm.zeronews.presentation.models

data class Article(
    val title: String,
    val description: String,
    val imageURL: String?,
    val author: String,
    val publishedDate: String,
)
