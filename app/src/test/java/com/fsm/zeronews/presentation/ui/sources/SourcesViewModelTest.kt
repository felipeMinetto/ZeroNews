package com.fsm.zeronews.presentation.ui.sources

import com.fsm.zeronews.TestDispatchers
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.respository.SourcesRepository
import com.fsm.zeronews.data.sourceApiList
import com.fsm.zeronews.presentation.models.Source
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@OptIn(ExperimentalCoroutinesApi::class)
class SourcesViewModelTest {

    private val repository: SourcesRepository = mock {
        onBlocking { fetchSources() } doReturn ApiResult.Success(sourceApiList) as ApiResult<List<Source>>
    }

    @Test
    fun `fetchSources sets sources on success`() = runTest {
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        advanceUntilIdle()
        assertEquals(viewModel.sources.value, sourceApiList)
        assertEquals(viewModel.error.value, false)
    }

    @Test
    fun `fetchSources sets error on error`() = runTest {
        repository.stub {
            onBlocking { fetchSources() } doReturn ApiResult.Error()
        }
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        advanceUntilIdle()
        assertEquals(viewModel.error.value, true)
        assertEquals(viewModel.errorMessage.value, "")
    }

    @Test
    fun `fetchSources sets errorMessage on specific error`() = runTest {
        repository.stub {
            onBlocking { fetchSources() } doReturn ApiResult.Error(Exception("Error message"))
        }
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        advanceUntilIdle()
        assertEquals(viewModel.error.value, true)
        assertEquals(viewModel.errorMessage.value, "Error message")
    }

    @Test
    fun `fetchSources modifies isLoading correctly on success`() = runTest {
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        assertEquals(viewModel.isLoading.value, true)
        advanceUntilIdle()
        assertEquals(viewModel.isLoading.value, false)
    }

    @Test
    fun `fetchSources modifies isLoading correctly on error`() = runTest {
        repository.stub {
            onBlocking { fetchSources() } doReturn ApiResult.Error()
        }
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        assertEquals(viewModel.isLoading.value, true)
        advanceUntilIdle()
        assertEquals(viewModel.isLoading.value, false)
    }

    @Test
    fun `fetchSources sets isLoading and error when called a second time after error`() = runTest {
        repository.stub {
            onBlocking { fetchSources() } doReturn ApiResult.Error(Exception("Error message"))
        }
        val viewModel = SourcesViewModel(repository, TestDispatchers(testScheduler))
        advanceUntilIdle()
        assertEquals(viewModel.isLoading.value, false)
        assertEquals(viewModel.error.value, true)

        repository.stub {
            onBlocking { fetchSources() } doReturn ApiResult.Success(sourceApiList) as ApiResult<List<Source>>
        }
        viewModel.fetchSources()

        assertEquals(viewModel.isLoading.value, true)
        assertEquals(viewModel.error.value, false)

        advanceUntilIdle()
        assertEquals(viewModel.isLoading.value, false)
        assertEquals(viewModel.sources.value, sourceApiList)
        assertEquals(viewModel.error.value, false)
    }

}