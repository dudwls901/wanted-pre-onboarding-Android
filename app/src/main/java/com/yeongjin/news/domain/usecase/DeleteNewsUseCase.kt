package com.yeongjin.news.domain.usecase

import com.yeongjin.news.data.model.News
import com.yeongjin.news.domain.repository.SavedNewsRepository
import javax.inject.Inject

class DeleteNewsUseCase @Inject constructor(
    private val savedNewsRepository: SavedNewsRepository,
) {
    suspend operator fun invoke(news: News) {
        savedNewsRepository.deleteNews(news)
    }
}