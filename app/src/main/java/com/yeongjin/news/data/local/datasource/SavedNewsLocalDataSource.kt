package com.yeongjin.news.data.local.datasource

import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow

interface SavedNewsLocalDataSource {
    fun getNewsList(): Flow<List<News>>
    suspend fun saveNews(news: News)
    suspend fun deleteNews(news: News)
}