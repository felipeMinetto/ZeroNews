package com.fsm.zeronews.data.respository

import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.models.SourceApi
import com.fsm.zeronews.di.DispatcherProvider
import com.fsm.zeronews.presentation.models.Source
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SourcesRepository @Inject constructor(
    private val api: API,
    private val dispatchers: DispatcherProvider,
) {
    suspend fun fetchSources(): ApiResult<List<Source>> {
        return withContext(dispatchers.io) {
            try {
                val result = api.getSources()
                if (result.isSuccess) {
                    result.sources?.let { source ->
                        return@withContext ApiResult.Success(source.map { it.toUIModel() })
                    }
                }
            } catch (exception: CancellationException) {
                throw exception
            } catch (exception: Exception) {
                return@withContext ApiResult.Error(exception)
            }
            ApiResult.Error()
        }
    }
}

fun SourceApi.toUIModel(): Source {
    return Source(id, name, description, url)
}