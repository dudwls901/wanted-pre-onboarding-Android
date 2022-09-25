package com.yeongjin.news.domain.usecase

import com.yeongjin.news.data.model.News
import com.yeongjin.news.domain.repository.SavedNewsRepository
import javax.inject.Inject

class SaveNewsUseCase @Inject constructor(
    private val savedNewsRepository: SavedNewsRepository,
) {
    suspend operator fun invoke(news: News) {
        savedNewsRepository.saveNews(news)
    }
}