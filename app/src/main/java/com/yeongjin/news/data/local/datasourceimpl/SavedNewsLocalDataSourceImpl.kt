package com.yeongjin.news.data.local.datasourceimpl

import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedNewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao,
) : SavedNewsLocalDataSource {
    override fun getNewsList(): Flow<List<News>> = newsDao.getNewsList()

    override suspend fun saveNews(news: News) {
        newsDao.saveNews(news)
    }

    override suspend fun deleteNews(news: News) {
        newsDao.deleteNews(news)
    }
}