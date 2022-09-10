package com.yeongjin.news.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yeongjin.news.data.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_table ORDER BY publishedAt DESC")
    fun getNewsList(): Flow<List<News>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveNews(news: News)

    @Delete
    suspend fun deleteNews(news: News)

}