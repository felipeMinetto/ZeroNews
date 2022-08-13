package com.fsm.zeronews.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<ArticleApi>,
)
