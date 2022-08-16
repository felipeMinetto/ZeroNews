package com.fsm.zeronews

import com.fsm.zeronews.data.models.ArticleApi
import com.fsm.zeronews.data.models.SourceApi
import com.fsm.zeronews.data.models.SourcesResponse
import com.fsm.zeronews.presentation.models.Article
import com.fsm.zeronews.presentation.models.Source

val sourceApiList = listOf(
    SourceApi("1",
        "Source Name",
        "Description of the source",
        "https://source.com",
        "category",
        "en",
        "US"),
    SourceApi("2",
        "Source Name",
        "Description of the source",
        "https://source.com",
        "category",
        "en",
        "US"),
    SourceApi("3",
        "Source Name",
        "Description of the source",
        "https://source.com",
        "category",
        "en",
        "US"),
    SourceApi("4",
        "Source Name",
        "Description of the source",
        "https://source.com",
        "category",
        "en",
        "US")
)

val sourceList = listOf(
    Source(
        "1",
        "Source Name",
        "Description of the source",
        "https://source.com",
    ),
    Source(
        "2",
        "Source Name",
        "Description of the source",
        "https://source.com",
    ),
    Source(
        "3",
        "Source Name",
        "Description of the source",
        "https://source.com",
    ),
    Source(
        "4",
        "Source Name",
        "Description of the source",
        "https://source.com",
    ),
)

val sourcesResponseSuccess = SourcesResponse(
    status = "ok",
    sources = sourceApiList,
    code = null,
    message = null
)

val sourcesResponseError = SourcesResponse(
    status = "error",
    sources = null,
    message = "Failed to load sources",
    code = "error code"
)

val mockDate = "2022-08-03T11:00:00Z"

val articleApiList = listOf(
    ArticleApi("John Doe",
        "Article 1",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
    ArticleApi("John Doe",
        "Article 2",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
    ArticleApi("John Doe",
        "Article 3",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
    ArticleApi("John Doe",
        "Article 4",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
    ArticleApi("John Doe",
        "Article 5",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
    ArticleApi("John Doe",
        "Article 6",
        "Some nice article from the source",
        "https://english.chosun.com/",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        mockDate,
        ""),
)

val articleList = listOf(
    Article(
        "Article 1",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
    Article(
        "Article 2",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
    Article(
        "Article 3",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
    Article(
        "Article 4",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
    Article(
        "Article 5",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
    Article(
        "Article 6",
        "Some nice article from the source",
        "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        "John Doe",
        "03-08-2022",
    ),
)