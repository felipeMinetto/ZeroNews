package com.fsm.zeronews.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourcesResponse(
    val status: String,
    val sources: List<SourceApi>,
)
