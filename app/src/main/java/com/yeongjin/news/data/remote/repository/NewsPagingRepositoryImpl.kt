package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.data.remote.ApiRequestFactory
import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource
import com.yeongjin.news.data.remote.api.NewsApi
import retrofit2.Response

class NewsPagingRepositoryImpl: NewsPagingRepository {
    override fun getTopNewsList(country: String) = NewsPagingSource(ApiRequestFactory.newsApiService, country)

    override fun getCategoryNewsList(
        country: String,
        category: String
    ) = CategoryNewsPagingSource(ApiRequestFactory.newsApiService, country, category)

}