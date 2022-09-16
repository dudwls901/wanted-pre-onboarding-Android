package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.data.remote.ApiRequestFactory
import com.yeongjin.news.data.remote.NewsPagingSource
import com.yeongjin.news.data.remote.api.NewsApi
import retrofit2.Response

class NewsPagingRepository {
    fun getTopNewsList(country: String) = NewsPagingSource(ApiRequestFactory.newsApiService, country)

//    fun getCategoryNewsList(
//        country: String,
//        category: String
//    ): Response<NewsList> = ApiRequestFactory.newsApiService.getCategoryNewsList(country, category)

}