package com.fsm.zeronews.ui.sources

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fsm.zeronews.data.respository.SourcesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(
    private val sourcesRepository: SourcesRepository,
) : ViewModel() {

    fun fetchSources() {
        viewModelScope.launch(Dispatchers.IO) {
            sourcesRepository.fetchSources()
        }
    }
}