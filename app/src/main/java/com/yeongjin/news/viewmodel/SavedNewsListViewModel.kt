package com.yeongjin.news.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.local.NewsDatabase
import com.yeongjin.news.data.local.repository.SavedNewsRepository
import com.yeongjin.news.data.local.repository.SavedNewsRepositoryImpl
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.launch

class SavedNewsListViewModel(application: Application): AndroidViewModel(application) {
    private val newsDao: NewsDao by lazy { NewsDatabase.getDatabase(application).toDoDao()}
    private val savedNewsRepo: SavedNewsRepository by lazy { SavedNewsRepositoryImpl(newsDao) }
    private val TAG = SavedNewsListViewModel::class.java.name

    var newsList: LiveData<List<News>> = SavedNewsRepositoryImpl(newsDao).getNewsList().asLiveData()

    fun saveNews(news: News) = viewModelScope.launch{
        savedNewsRepo.saveNews(news)
    }
}