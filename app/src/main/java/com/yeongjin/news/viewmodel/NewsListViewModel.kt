package com.yeongjin.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.repository.NewsRepositoryImpl
import com.yeongjin.news.global.Constants
import kotlinx.coroutines.launch

class NewsListViewModel: ViewModel() {
    private val TAG = NewsListViewModel::class.java.name

    private var _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    fun getNews() = viewModelScope.launch{
        val newsRepo = NewsRepositoryImpl()
        val result = newsRepo.getTopNewsList(Constants.Country.US.name)
        if(result.isSuccessful){
            if(result.code()==200){
                result.body()?.let{ body ->
                    _newsList.value = body.articles
                }
            }
        }
        else{
            Log.e(TAG, "getNews: ${result.errorBody()}")
        }
    }
}