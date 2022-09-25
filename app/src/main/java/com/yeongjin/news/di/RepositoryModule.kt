package com.yeongjin.news.di

import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.local.repository.SavedNewsRepository
import com.yeongjin.news.data.local.repository.SavedNewsRepositoryImpl
import com.yeongjin.news.data.remote.api.NewsApi
import com.yeongjin.news.data.remote.repository.NewsPagingRepository
import com.yeongjin.news.data.remote.repository.NewsPagingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
    ): NewsPagingRepository {
        return NewsPagingRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideSavedNewsRepository(
        savedNewsLocalDataSource: SavedNewsLocalDataSource,
    ): SavedNewsRepository {
        return SavedNewsRepositoryImpl(savedNewsLocalDataSource)
    }
}