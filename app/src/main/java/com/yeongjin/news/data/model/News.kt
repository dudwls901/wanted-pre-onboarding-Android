package com.yeongjin.news.data.model

import android.os.Build
import android.os.Parcelable
import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.logging.SimpleFormatter

@kotlinx.parcelize.Parcelize
@Entity(tableName = "news_table")
data class News(
    val author: String? = "",
    @PrimaryKey val title: String,
    val description: String? = "",
    val urlToImage: String? = "",
    val publishedAt: String,
    val content: String? = ""
) : Parcelable {
    fun getBetweenDateTime(): String {
        val format = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val formatter = DateTimeFormatter.ofPattern(format)
        val prev = LocalDateTime.parse(publishedAt, formatter)
        val current = LocalDateTime.now()
        val hours: Long = ChronoUnit.HOURS.between(prev, current)
        val days: Long = ChronoUnit.DAYS.between(prev, current)
        val months: Long = ChronoUnit.MONTHS.between(prev, current)
        return if (hours < 24L) "$hours hours ago"
        else if (days < 30L) "$days days ago"
        else "$months months ago"
    }
}

data class NewsList(
    val articles: List<News>
)