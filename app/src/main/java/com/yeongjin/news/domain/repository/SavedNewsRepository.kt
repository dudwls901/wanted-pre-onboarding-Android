package com.yeongjin.news.domain.repository

import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow

//todo data model -> domain model
interface SavedNewsRepository {
    fun getNewsList(): Flow<List<News>>
    suspend fun saveNews(news: News)
    suspend fun deleteNews(news: News)
}