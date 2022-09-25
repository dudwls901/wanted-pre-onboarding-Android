package com.yeongjin.news.domain.usecase

import com.yeongjin.news.domain.repository.NewsPagingRepository
import javax.inject.Inject

class getCategoryNewsListUseCase @Inject constructor(
    private val newsPagingRepository: NewsPagingRepository,
) {
    operator fun invoke(
        country: String,
        category: String,
    ) = newsPagingRepository.getCategoryNewsList(country, category)
}