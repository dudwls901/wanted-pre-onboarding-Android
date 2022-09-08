package com.yeongjin.news.data.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class News(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
): Parcelable

data class NewsList(
    val articles: List<News>
)