package com.yeongjin.news.data.repository

import com.yeongjin.news.data.model.Category
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.model.NewsList
import retrofit2.Response

interface NewsRepository {
    suspend fun getTopNewsList(country: String): Response<NewsList>
    suspend fun getCategoryNewsList(country: String, category: String): Response<NewsList>
}