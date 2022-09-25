package com.yeongjin.news.data.local.repository

import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedNewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
) : SavedNewsRepository {
    override fun getNewsList(): Flow<List<News>> = newsDao.getNewsList()

    override suspend fun saveNews(news: News) {
        newsDao.saveNews(news)
    }

    override suspend fun deleteNews(news: News) {
        newsDao.deleteNews(news)
    }
}