package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.data.remote.ApiRequestFactory
import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource
import com.yeongjin.news.data.remote.api.NewsApi
import retrofit2.Response

interface NewsPagingRepository {
    fun getTopNewsList(country: String): NewsPagingSource

    fun getCategoryNewsList(
        country: String,
        category: String
    ): CategoryNewsPagingSource

}