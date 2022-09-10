package com.yeongjin.news.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.GET

@kotlinx.parcelize.Parcelize
@Entity(tableName = "news_table")
data class News(
    val author: String? = "",
    @PrimaryKey val title: String,
    val description: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String,
    val content: String? = ""
) : Parcelable

data class NewsList(
    val articles: List<News>
)