package com.yeongjin.news.data.remote.api

import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.global.Constants.TOP_HEADLINES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET(TOP_HEADLINES)
    suspend fun getNewsList(@Query("country") country: String): Response<NewsList>
}