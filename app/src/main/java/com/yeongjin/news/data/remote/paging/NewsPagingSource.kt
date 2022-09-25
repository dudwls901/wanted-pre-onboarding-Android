package com.yeongjin.news.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.remote.api.NewsApi
import com.yeongjin.news.global.Constants.NETWORK_PAGE_SIZE
import com.yeongjin.news.global.Constants.NEWS_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val country: String
) : PagingSource<Int, News>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        val position = params.key ?: NEWS_STARTING_PAGE_INDEX
        return try {
            val response = newsApi.getTopNewsList(country, position, params.loadSize)
            val newsList = response.body()?.articles
            val nextKey = if (newsList == null || newsList.isEmpty()) null else {
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = newsList?: emptyList(),
                prevKey = if( position == NEWS_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}