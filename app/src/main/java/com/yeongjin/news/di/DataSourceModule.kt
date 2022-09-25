package com.yeongjin.news.di

import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.local.datasourceimpl.SavedNewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideSavedNewsLocalDataSource(
        newsDao: NewsDao,
    ): SavedNewsLocalDataSource {
        return SavedNewsLocalDataSourceImpl(newsDao)
    }
}