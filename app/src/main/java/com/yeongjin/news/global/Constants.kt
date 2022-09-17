package com.yeongjin.news.global

object Constants {

    const val  baseURL = "https://newsapi.org/v2/"
    const val TOP_HEADLINES = "top-headlines"
    const val NEWS_STARTING_PAGE_INDEX = 1
    const val NETWORK_PAGE_SIZE = 5

    enum class COUNTRY{
        US
    }

    enum class CATEGORY{
        BUSINESS, ENTERTAINMENT, GENERAL, HEALTH, SCIENCE, SPORTS, TECHNOLOGY
    }
}