package com.fsm.zeronews.data.respository

import com.fsm.zeronews.TestDispatchers
import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.sourceList
import com.fsm.zeronews.data.sourcesResponseError
import com.fsm.zeronews.data.sourcesResponseSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class SourcesRepositoryTest {

    private val api: API = mock()

    @Test
    fun `fetchSources returns ApiResult_Success on success`() = runTest {
        api.stub {
            onBlocking { getSources() } doReturn sourcesResponseSuccess
        }

        val repository = SourcesRepository(api, TestDispatchers(testScheduler))
        val result = repository.fetchSources()

        val expected = ApiResult.Success(sourceList)
        assertEquals(expected, result)
    }

    @Test
    fun `fetchSources returns ApiResult_Error with empty error on request fail`() = runTest {
        api.stub {
            onBlocking { getSources() } doReturn sourcesResponseError
        }

        val repository = SourcesRepository(api, TestDispatchers(testScheduler))
        val result = repository.fetchSources()

        val expected = ApiResult.Error()
        assertEquals(expected, result)
    }

    @Test
    fun `fetchSources returns ApiResult_Error with exception when exception is thrown`() = runTest {
        val exception = MockitoKotlinException("Exception message", null)
        api.stub {
            onBlocking { getSources() } doThrow exception
        }

        val repository = SourcesRepository(api, TestDispatchers(testScheduler))
        val result = repository.fetchSources()

        val expected = ApiResult.Error(exception)
        assertEquals(expected, result)
    }
}