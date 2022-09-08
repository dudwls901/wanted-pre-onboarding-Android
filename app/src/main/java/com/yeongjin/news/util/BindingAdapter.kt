package com.yeongjin.news.util

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.yeongjin.news.R
import com.yeongjin.news.data.model.News
import com.yeongjin.news.view.newslist.NewsListFragmentDirections

object BindingAdapter {

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun setImageUri(view: ImageView, imageUrl: Any){
        Glide.with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_news_24)
            .into(view)
    }

    @BindingAdapter("android:sendDataToDetailFragment")
    @JvmStatic
    fun sendDataToDetailFragment(view: ConstraintLayout, news: News){
        view.setOnClickListener {
            val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(news)
            view.findNavController().navigate(action)
        }
    }
}