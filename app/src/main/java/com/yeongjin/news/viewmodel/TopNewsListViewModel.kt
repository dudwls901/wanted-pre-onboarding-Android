package com.yeongjin.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.remote.repository.NewsPagingRepositoryImpl
import com.yeongjin.news.global.Constants

class TopNewsListViewModel: ViewModel() {
    private val TAG = TopNewsListViewModel::class.java.name

    private val newsPagingRepositoryImpl = NewsPagingRepositoryImpl()

    private var _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    val pagingNewsList = Pager(
        config = PagingConfig(
            pageSize = Constants.NETWORK_PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { newsPagingRepositoryImpl.getTopNewsList(Constants.COUNTRY.US.name) }
    ).liveData.cachedIn(viewModelScope)
    //cachedIn : scope 내에서 흐름을 활성 상태로 유지하고 결과를 다시 pagingNewsList에 함당

}