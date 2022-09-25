package com.yeongjin.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yeongjin.news.data.local.dao.NewsDao
import com.yeongjin.news.data.model.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

}