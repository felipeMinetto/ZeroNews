package com.fsm.zeronews.data.models

import com.fsm.zeronews.presentation.models.Source
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceApi(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String,
)

fun SourceApi.toUIModel(): Source {
    return Source(id, name, description, url)
}
