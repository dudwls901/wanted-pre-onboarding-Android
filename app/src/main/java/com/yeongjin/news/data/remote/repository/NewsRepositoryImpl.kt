package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.data.remote.ApiRequestFactory
import retrofit2.Response

class NewsRepositoryImpl : NewsRepository {
    override suspend fun getTopNewsList(country: String): Response<NewsList> {
        return ApiRequestFactory.newsApiService.getTopNewsList(country)
    }

    override suspend fun getCategoryNewsList(
        country: String,
        category: String
    ): Response<NewsList> = ApiRequestFactory.newsApiService.getCategoryNewsList(country, category)

}