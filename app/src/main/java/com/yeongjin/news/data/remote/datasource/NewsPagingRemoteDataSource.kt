package com.yeongjin.news.data.remote.datasource

import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource

interface NewsPagingRemoteDataSource {
    fun getTopNewsList(country: String): NewsPagingSource

    fun getCategoryNewsList(
        country: String,
        category: String,
    ): CategoryNewsPagingSource

}