package com.yeongjin.news.data.remote.datasourceimpl

import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource
import com.yeongjin.news.data.remote.api.NewsApi
import com.yeongjin.news.data.remote.datasource.NewsPagingRemoteDataSource
import javax.inject.Inject

class NewsPagingRemoteDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi,
) : NewsPagingRemoteDataSource {
    override fun getTopNewsList(country: String) = NewsPagingSource(newsApi, country)

    override fun getCategoryNewsList(
        country: String,
        category: String,
    ) = CategoryNewsPagingSource(newsApi, country, category)

}