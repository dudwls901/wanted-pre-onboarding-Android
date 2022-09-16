package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.model.NewsList
import retrofit2.Response

interface NewsRepository {
    suspend fun getCategoryNewsList(country: String, category: String): Response<NewsList>
}