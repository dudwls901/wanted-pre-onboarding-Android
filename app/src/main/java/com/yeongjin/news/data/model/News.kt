package com.yeongjin.news.data.model

data class News(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
data class NewsList(
    val articles: List<News>
)