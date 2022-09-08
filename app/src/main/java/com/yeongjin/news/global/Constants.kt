package com.yeongjin.news.global

object Constants {

    const val  baseURL = "https://newsapi.org/v2/"
    const val TOP_HEADLINES = "top-headlines"

    enum class COUNTRY{
        US
    }

    enum class CATEGORY{
        BUSINESS, ENTERTAINMENT, GENERAL, HEALTH, SCIENCE, SPORTS, TECHNOLOGY
    }
}