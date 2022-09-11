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

class NewsListIntCategoryViewModel: NewsListViewModel() {
    override val TAG = NewsListIntCategoryViewModel::class.java.name
}