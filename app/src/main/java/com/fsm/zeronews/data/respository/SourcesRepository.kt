package com.fsm.zeronews.data.respository

import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.toUIModel
import com.fsm.zeronews.ui.models.Source
import javax.inject.Inject

class SourcesRepository @Inject constructor(
    private val api: API,
) {

    suspend fun fetchSources(): List<Source> {
        return api.getSources().sources.map { it.toUIModel() }
    }
}