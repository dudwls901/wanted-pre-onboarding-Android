package com.yeongjin.news.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.yeongjin.news.data.local.NewsDao
import com.yeongjin.news.data.local.NewsDatabase
import com.yeongjin.news.data.local.repository.SavedNewsRepository
import com.yeongjin.news.data.local.repository.SavedNewsRepositoryImpl
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.launch

class SavedNewsListViewModel(application: Application) : AndroidViewModel(application) {
    private val newsDao: NewsDao by lazy { NewsDatabase.getDatabase(application).toDoDao() }
    private val savedNewsRepo: SavedNewsRepository by lazy { SavedNewsRepositoryImpl(newsDao) }
    private val TAG = SavedNewsListViewModel::class.java.name

    var newsList: LiveData<List<News>> = SavedNewsRepositoryImpl(newsDao).getNewsList().asLiveData()

    private var _news = MutableLiveData<News>()
    val news: LiveData<News>
        get() = _news

    private var _liked = MutableLiveData<Boolean>()
    val liked: LiveData<Boolean>
        get() = _liked

    private fun saveNews() = viewModelScope.launch {
        savedNewsRepo.saveNews(news.value!!)
    }

    private fun deleteNews() = viewModelScope.launch {
        savedNewsRepo.deleteNews(news.value!!)
    }

    fun onLikeButtonClick() {
        if (_liked.value == true) {
            deleteNews()
            _liked.value = false
        } else {
            saveNews()
            _liked.value = true
        }
    }

    fun setNews(clickedNews: News) {
        _news.value = clickedNews
        setLiked(clickedNews)
    }

    private fun setLiked(clickedNews: News) {
        var isExist = false
        newsList.value?.forEach { news ->
            if (news == clickedNews) {
                isExist = true
                return@forEach
            }
        }
        _liked.value = isExist
    }
}