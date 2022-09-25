package com.yeongjin.news.data.remote.repository

import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource
import com.yeongjin.news.data.remote.api.NewsApi
import javax.inject.Inject

//todo datasource로 빼기
class NewsPagingRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsPagingRepository {
    override fun getTopNewsList(country: String) = NewsPagingSource(newsApi, country)

    override fun getCategoryNewsList(
        country: String,
        category: String
    ) = CategoryNewsPagingSource(newsApi, country, category)

}