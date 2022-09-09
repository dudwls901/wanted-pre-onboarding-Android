package com.yeongjin.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeongjin.news.data.model.News
import com.yeongjin.news.data.remote.repository.NewsRepositoryImpl
import com.yeongjin.news.global.Constants
import kotlinx.coroutines.launch

class NewsListIntCategoryViewModel: ViewModel() {
    private val TAG = NewsListIntCategoryViewModel::class.java.name

    private var _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>>
        get() = _newsList

    fun getCategoryNews(category: String) = viewModelScope.launch{
        val newsRepo = NewsRepositoryImpl()
        val result = newsRepo.getCategoryNewsList(Constants.COUNTRY.US.name, category)
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