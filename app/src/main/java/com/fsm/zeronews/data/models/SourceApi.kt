package com.fsm.zeronews.data.models

import com.fsm.zeronews.ui.models.Source

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
