package com.yeongjin.news.domain.usecase

import com.yeongjin.news.domain.repository.SavedNewsRepository
import javax.inject.Inject

class GetSavedNewsListUseCase @Inject constructor(
    private val savedNewsRepository: SavedNewsRepository,
) {
    operator fun invoke() = savedNewsRepository.getNewsList()
}