package com.yeongjin.news.di

import com.yeongjin.news.data.local.datasource.SavedNewsLocalDataSource
import com.yeongjin.news.data.remote.datasource.NewsPagingRemoteDataSource
import com.yeongjin.news.data.repositoryimpl.NewsPagingRepositoryImpl
import com.yeongjin.news.data.repositoryimpl.SavedNewsRepositoryImpl
import com.yeongjin.news.domain.repository.NewsPagingRepository
import com.yeongjin.news.domain.repository.SavedNewsRepository
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
        newsPagingRemoteDataSource: NewsPagingRemoteDataSource,
    ): NewsPagingRepository {
        return NewsPagingRepositoryImpl(newsPagingRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideSavedNewsRepository(
        savedNewsLocalDataSource: SavedNewsLocalDataSource,
    ): SavedNewsRepository {
        return SavedNewsRepositoryImpl(savedNewsLocalDataSource)
    }
}