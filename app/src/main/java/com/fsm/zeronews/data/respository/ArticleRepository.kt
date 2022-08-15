package com.fsm.zeronews.data.respository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.ArticleApi
import com.fsm.zeronews.di.DateFormatter
import com.fsm.zeronews.presentation.models.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val api: API,
) {
    fun getArticlesFlow(source: String): Flow<PagingData<Article>> {
        return Pager(
            PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { ArticlePagingSource(api, source) }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 10
    }
}

fun ArticleApi.toUIModel(): Article {
    return Article(
        title ?: "-No Title-",
        description,
        urlToImage,
        author ?: "Anonymous author",
        DateFormatter.formatDate(publishedAt)
    )
}