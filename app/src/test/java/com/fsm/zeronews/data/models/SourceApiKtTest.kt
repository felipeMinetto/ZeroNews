package com.fsm.zeronews.data.models

import com.fsm.zeronews.ui.models.Source
import org.junit.Assert
import org.junit.Test

class SourceApiKtTest {
    private val sourceApi = SourceApi(
        "abc-news",
        "ABC News",
        "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
        "https://abcnews.go.com",
        "general",
        "en",
        "us"
    )

    @Test
    fun convert_toUIModel() {
        val expected = Source(
            "abc-news",
            "ABC News",
            "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
            "https://abcnews.go.com",
        )

        val result = sourceApi.toUIModel()

        Assert.assertEquals(expected, result)
    }
}