package com.yeongjin.news.data.repository
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.model.NewsList
import com.yeongjin.news.data.remote.ApiRequestFactory
import com.yeongjin.news.global.Constants
import retrofit2.Response

class NewsRepositoryImpl : NewsRepository {
    override suspend fun getNews(country: String): Response<NewsList> {
        return ApiRequestFactory.newsApiService.getNewsList(country)
    }


}