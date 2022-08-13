package com.fsm.zeronews.data.respository

import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.models.toUIModel
import com.fsm.zeronews.ui.models.Source
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SourcesRepository @Inject constructor(
    private val api: API,
) {

    suspend fun fetchSources(): ApiResult<List<Source>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = api.getSources()
                if (result.isSuccess) {
                    result.sources?.let { source ->
                        return@withContext ApiResult.Success(source.map { it.toUIModel() })
                    }
                }
            } catch (exception: Exception) {
                if (exception is CancellationException) throw exception
                ApiResult.Error(exception)
            }
            ApiResult.Error(Exception())
        }
    }
}