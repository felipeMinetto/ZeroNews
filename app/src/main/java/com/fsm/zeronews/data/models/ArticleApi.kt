package com.fsm.zeronews.data.models

import com.fsm.zeronews.ui.models.Article
import java.text.SimpleDateFormat
import java.util.*

data class ArticleApi(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Date,
    val content: String,
)

fun ArticleApi.toUIModel(): Article {
    val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return Article(title, description, urlToImage, author, formattedDate.format(publishedAt))
}

