package com.yeongjin.news.di

import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.local.datasourceimpl.SavedNewsLocalDataSourceImpl
import com.yeongjin.news.data.remote.api.NewsApi
import com.yeongjin.news.data.remote.datasource.NewsPagingRemoteDataSource
import com.yeongjin.news.data.remote.datasourceimpl.NewsPagingRemoteDataSourceImpl
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

    @Singleton
    @Provides
    fun provideNewsPagingRemoteDataSource(
        newsApi: NewsApi,
    ): NewsPagingRemoteDataSource {
        return NewsPagingRemoteDataSourceImpl(newsApi)
    }
}