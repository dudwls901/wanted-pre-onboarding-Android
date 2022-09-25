package com.yeongjin.news.data.repository

import com.yeongjin.news.data.remote.CategoryNewsPagingSource
import com.yeongjin.news.data.remote.NewsPagingSource

interface NewsPagingRepository {
    fun getTopNewsList(country: String): NewsPagingSource

    fun getCategoryNewsList(
        country: String,
        category: String
    ): CategoryNewsPagingSource

}