package com.fsm.zeronews.presentation.ui.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fsm.zeronews.data.respository.ArticleRepository
import com.fsm.zeronews.presentation.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {

    fun fetchArticles(source: String): Flow<PagingData<Article>> {
        return articleRepository.getArticlesFlow(source).cachedIn(viewModelScope)
    }
}