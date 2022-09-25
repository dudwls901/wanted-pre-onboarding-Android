package com.yeongjin.news.data.repositoryimpl

import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.repository.SavedNewsRepository
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedNewsRepositoryImpl @Inject constructor(
    private val savedNewsLocalDataSource: SavedNewsLocalDataSource,
) : SavedNewsRepository {
    override fun getNewsList(): Flow<List<News>> = savedNewsLocalDataSource.getNewsList()

    override suspend fun saveNews(news: News) {
        savedNewsLocalDataSource.saveNews(news)
    }

    override suspend fun deleteNews(news: News) {
        savedNewsLocalDataSource.deleteNews(news)
    }
}