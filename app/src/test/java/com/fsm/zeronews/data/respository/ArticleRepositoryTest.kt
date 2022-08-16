package com.fsm.zeronews.data.respository

import com.fsm.zeronews.articleApiList
import com.fsm.zeronews.articleList
import org.junit.Assert.assertEquals
import org.junit.Test

class ArticleRepositoryTest {

    @Test
    fun `toUIModel converts ArticleApi to Article`() {
        val articleApi = articleApiList.first()
        val expected = articleList.first()

        assertEquals(expected, articleApi.toUIModel())
    }
}