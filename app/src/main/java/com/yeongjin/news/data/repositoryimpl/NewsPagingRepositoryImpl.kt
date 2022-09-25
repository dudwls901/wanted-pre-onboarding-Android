package com.yeongjin.news.data.repositoryimpl

import com.yeongjin.news.data.remote.datasource.NewsPagingRemoteDataSource
import com.yeongjin.news.data.repository.NewsPagingRepository
import javax.inject.Inject

class NewsPagingRepositoryImpl @Inject constructor(
    private val newsPagingRemoteDataSource: NewsPagingRemoteDataSource,
) : NewsPagingRepository {
    override fun getTopNewsList(country: String) = newsPagingRemoteDataSource.getTopNewsList(country)

    override fun getCategoryNewsList(
        country: String,
        category: String,
    ) = newsPagingRemoteDataSource.getCategoryNewsList(country, category)

}