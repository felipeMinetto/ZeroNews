package com.fsm.zeronews.data.respository

import androidx.paging.PagingSource.LoadParams.Refresh
import androidx.paging.PagingSource.LoadResult.Error
import androidx.paging.PagingSource.LoadResult.Page
import com.fsm.zeronews.articleApiList
import com.fsm.zeronews.articleList
import com.fsm.zeronews.data.api.API
import com.fsm.zeronews.data.models.ArticlesResponse
import com.fsm.zeronews.presentation.models.Article
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.*

@OptIn(ExperimentalCoroutinesApi::class)
class ArticlePagingSourceTest {

    private val api: API = mock()

    @Test
    fun `load returns Page on success`() = runTest {
        api.stub {
            onBlocking { getArticles(any(), any(), any()) } doReturn ArticlesResponse("ok",
                null,
                null,
                articleList.size,
                articleApiList)
        }

        val pagingSource = ArticlePagingSource(api, "source")
        val expected = Page(
            data = articleList,
            null,
            2
        )
        val result = pagingSource.load(Refresh(
            key = null,
            loadSize = 10,
            placeholdersEnabled = false
        ))

        assertEquals(expected, result)
    }

    @Test
    fun `load returns Error on Api failure`() = runTest {
        api.stub {
            onBlocking { getArticles(any(), any(), any()) } doReturn ArticlesResponse(
                "error",
                "some code",
                "message",
                null,
                null,
            )
        }

        val pagingSource = ArticlePagingSource(api, "source")
        val expected = Error<Int, Article>(Exception("Articles API request failed"))
        val result = pagingSource.load(Refresh(
            key = null,
            loadSize = 10,
            placeholdersEnabled = false
        ))

        assertEquals(expected.toString(), result.toString())
    }

    @Test
    fun `load returns Error on exception thrown`() = runTest {
        val exception = MockitoKotlinException("exception", null)
        api.stub {
            onBlocking { getArticles(any(), any(), any()) } doThrow exception
        }

        val pagingSource = ArticlePagingSource(api, "source")
        val expected = Error<Int, Article>(exception)
        val result = pagingSource.load(Refresh(
            key = null,
            loadSize = 10,
            placeholdersEnabled = false
        ))

        assertEquals(expected, result)
    }
}