package com.yeongjin.news.data.model

import com.yeongjin.news.global.Constants

data class Category(
    val imgResource: Int,
    val name: Constants.CATEGORY
){
    fun getNameLowString() = name.name.lowercase()
}
