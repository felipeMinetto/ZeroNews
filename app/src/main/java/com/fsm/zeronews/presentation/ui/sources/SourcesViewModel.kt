package com.fsm.zeronews.presentation.ui.sources

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.respository.SourcesRepository
import com.fsm.zeronews.di.DispatcherProvider
import com.fsm.zeronews.presentation.models.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val sourcesRepository: SourcesRepository,
    private val dispatchers: DispatcherProvider,
) : ViewModel() {

    val sources = mutableStateOf(emptyList<Source>())
    val isLoading = mutableStateOf(true)
    val error = mutableStateOf(false)
    val errorMessage = mutableStateOf("")

    init {
        fetchSources()
    }

    fun fetchSources() {
        isLoading.value = true
        error.value = false
        viewModelScope.launch(dispatchers.default) {
            when (val sourceResponse = sourcesRepository.fetchSources()) {
                is ApiResult.Error -> {
                    isLoading.value = false
                    error.value = true
                    errorMessage.value = sourceResponse.exception?.message ?: ""
                }
                is ApiResult.Success -> {
                    isLoading.value = false
                    sources.value = sourceResponse.result
                }
            }
        }
    }
}