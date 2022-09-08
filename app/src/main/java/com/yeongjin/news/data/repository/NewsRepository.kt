package com.yeongjin.news.data.repository
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.model.NewsList
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(country: String) : Response<NewsList>
}