package com.yeongjin.news.data.remote.datasource

import com.yeongjin.news.data.remote.paging.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.paging.NewsPagingSource

interface NewsPagingRemoteDataSource {
    fun getTopNewsList(country: String): NewsPagingSource

    fun getCategoryNewsList(
        country: String,
        category: String,
    ): CategoryNewsPagingSource

}