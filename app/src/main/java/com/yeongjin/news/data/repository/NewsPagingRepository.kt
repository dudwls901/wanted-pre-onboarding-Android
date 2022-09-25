package com.yeongjin.news.data.repository

import com.yeongjin.news.data.remote.paging.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.paging.NewsPagingSource

interface NewsPagingRepository {
    fun getTopNewsList(country: String): NewsPagingSource

    fun getCategoryNewsList(
        country: String,
        category: String
    ): CategoryNewsPagingSource

}