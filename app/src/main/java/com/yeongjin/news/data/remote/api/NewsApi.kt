package com.yeongjin.news.data.remote.api

import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.global.Constants.TOP_HEADLINES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&apiKey=aaa&page=1&pageSize=3
interface NewsApi {
    @GET(TOP_HEADLINES)
    suspend fun getTopNewsList(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NewsList>

    @GET(TOP_HEADLINES)
    suspend fun getCategoryNewsList(
        @Query("country") country: String,
        @Query("category") category: String
    ): Response<NewsList>
}