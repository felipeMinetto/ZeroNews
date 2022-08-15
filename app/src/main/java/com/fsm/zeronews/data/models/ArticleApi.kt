package com.fsm.zeronews.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleApi(
    val author: String?,
    val title: String?,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
)

