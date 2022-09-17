package com.yeongjin.news.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.yeongjin.news.data.remote.repository.NewsPagingRepositoryImpl
import com.yeongjin.news.global.Constants

class NewsListIntCategoryViewModel : ViewModel() {
    private val TAG = NewsListIntCategoryViewModel::class.java.name

    private val newsPagingRepositoryImpl = NewsPagingRepositoryImpl()

    private val query: MutableLiveData<String> = MutableLiveData()

    val pagingCategoryNewsList = query.switchMap { query ->
        Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                newsPagingRepositoryImpl.getCategoryNewsList(
                    Constants.COUNTRY.US.name,
                    query
                )
            }
        ).liveData.cachedIn(viewModelScope)
        //cachedIn : scope 내에서 흐름을 활성 상태로 유지하고 결과를 다시 pagingNewsList에 함당
    }


    fun getCategoryNews(category: String) {
        query.value = category
    }
}