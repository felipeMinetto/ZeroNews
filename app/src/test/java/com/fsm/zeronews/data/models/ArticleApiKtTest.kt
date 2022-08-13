package com.fsm.zeronews.data.models

import com.fsm.zeronews.ui.models.Article
import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat

class ArticleApiKtTest {
    private val articleApi = ArticleApi(
        "Gian M. Volpicelli",
        "The Rise and Fall of a Bitcoin Mining Sensation",
        "Compass Mining grew quickly during crypto’s halcyon days. Now, its customers and their thousands of mining machines are stuck.",
        "https://www.wired.com/story/compass-mining-bitcoin-russia/",
        "https://media.wired.com/photos/62e9c5e1d7368105da057de3/191:100/w_1280,c_limit/BitRiver-Mining-Center-Rise-And-Fall-Of-Bitcoin-Mining-Business-1184520941.jpg",
        SimpleDateFormat("yyyy-MM-dd").parse("2022-08-03")!!,
        "It was 8:45 in the morning of June 13 when Bill Stewart, the CEO of Maine-based bitcoin mining business Dynamics Mining, received a call from one of his employees. He's like, Every machine inside of … [+3472 chars]"
    )

    @Test
    fun convert_toUIModel() {
        val expected = Article(
            "The Rise and Fall of a Bitcoin Mining Sensation",
            "Compass Mining grew quickly during crypto’s halcyon days. Now, its customers and their thousands of mining machines are stuck.",
            "https://media.wired.com/photos/62e9c5e1d7368105da057de3/191:100/w_1280,c_limit/BitRiver-Mining-Center-Rise-And-Fall-Of-Bitcoin-Mining-Business-1184520941.jpg",
            "Gian M. Volpicelli",
            "2022-08-03"
        )

        val result = articleApi.toUIModel()

        Assert.assertEquals(expected, result)
    }
}