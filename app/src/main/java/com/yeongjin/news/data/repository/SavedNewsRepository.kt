package com.yeongjin.news.data.repository

import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface SavedNewsRepository {
    fun getNewsList(): Flow<List<News>>
    suspend fun saveNews(news: News)
    suspend fun deleteNews(news: News)
}