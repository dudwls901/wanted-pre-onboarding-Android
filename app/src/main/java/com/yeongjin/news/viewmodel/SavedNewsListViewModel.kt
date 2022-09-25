package com.yeongjin.news.viewmodel

import androidx.lifecycle.*
import com.yeongjin.news.data.model.News
import com.yeongjin.news.domain.usecase.DeleteNewsUseCase
import com.yeongjin.news.domain.usecase.GetSavedNewsListUseCase
import com.yeongjin.news.domain.usecase.SaveNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedNewsListViewModel @Inject constructor(
    getSavedNewsListUseCase: GetSavedNewsListUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val deleteNewsUseCase: DeleteNewsUseCase,
) : ViewModel() {
    private val TAG = SavedNewsListViewModel::class.java.name

    var newsList: LiveData<List<News>> = getSavedNewsListUseCase().asLiveData()

    private var _news = MutableLiveData<News>()
    val news: LiveData<News>
        get() = _news

    private var _liked = MutableLiveData<Boolean>()
    val liked: LiveData<Boolean>
        get() = _liked

    private fun saveNews() = viewModelScope.launch {
        saveNewsUseCase(news.value!!)
    }

    private fun deleteNews() = viewModelScope.launch {
        deleteNewsUseCase(news.value!!)
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