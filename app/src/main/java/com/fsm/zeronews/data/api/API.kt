package com.fsm.zeronews.data.api

import com.fsm.zeronews.data.models.ArticlesResponse
import com.fsm.zeronews.data.models.SourcesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("/v2/top-headlines/sources")
    suspend fun getSources(): SourcesResponse

    @GET("/v2/top-headlines/sources")
    suspend fun getArticles(
        @Query("page") page: Int,
        @Query("page_size") page_size: Int,
    ): ArticlesResponse
}