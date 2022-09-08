package com.yeongjin.news.global

object Constants {

    const val  baseURL = "https://newsapi.org/v2/"
    const val TOP_HEADLINES = "top-headlines"

    enum class Country{
        US
    }

    enum class Category{
        BUSINESS, ENTERTAINMENT, GENERAL, HELATH, SCIENCE, SPORTS, TECHNOLOGY
    }
}