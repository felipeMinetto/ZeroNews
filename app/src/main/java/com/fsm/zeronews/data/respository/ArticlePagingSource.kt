package com.fsm.zeronews.data.respository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.presentation.models.Article
import retrofit2.HttpException
import java.io.IOException

class ArticlePagingSource(
    private val api: API,
    private val source: String,
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val response = api.getArticles(page, params.loadSize, source)
            if (response.isSuccess) {
                val articles = response.articles.orEmpty().map { it.toUIModel() }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (articles.isEmpty()) null else page + (params.loadSize / ArticleRepository.PAGE_SIZE)
                LoadResult.Page(articles, prevKey, nextKey)
            } else {
                LoadResult.Error(Exception("Articles API request failed"))
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}