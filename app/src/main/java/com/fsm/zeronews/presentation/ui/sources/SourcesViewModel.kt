package com.fsm.zeronews.presentation.ui.sources

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fsm.zeronews.data.models.ApiResult
import com.fsm.zeronews.data.respository.SourcesRepository
import com.fsm.zeronews.presentation.models.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val sourcesRepository: SourcesRepository,
) : ViewModel() {

    val sources = mutableStateOf(emptyList<Source>())
    val isLoading = mutableStateOf(false)
    val error = mutableStateOf(false)

    init {
        fetchSources()
    }

    fun fetchSources() {
        viewModelScope.launch {
            isLoading.value = true
            when (val sourceResponse = sourcesRepository.fetchSources()) {
                is ApiResult.Error -> {
                    isLoading.value = false
                    error.value = true
                }
                is ApiResult.Success -> {
                    isLoading.value = false
                    sources.value = sourceResponse.result
                }
            }
        }
    }
}