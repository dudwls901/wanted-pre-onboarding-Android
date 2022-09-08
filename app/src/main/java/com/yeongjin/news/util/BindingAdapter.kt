package com.yeongjin.news.util

import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.yeongjin.news.R
import com.yeongjin.news.data.model.News
import com.yeongjin.news.global.Constants
import com.yeongjin.news.view.categories.NewsCategoryFragmentDirections
import com.yeongjin.news.view.categories.NewsListInCategoryFragmentDirections
import com.yeongjin.news.view.newslist.NewsListFragmentDirections
import java.lang.Exception

object BindingAdapter {

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun setImageUri(view: ImageView, imageUrl: Any?) {
        Glide.with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_news_24)
            .into(view)
    }

    @BindingAdapter("android:navigateWithData")
    @JvmStatic
    fun sendDataToDetailFragment(view: ConstraintLayout, data: Any) {
        view.setOnClickListener {
            when (data) {
                is News -> {
                    val action = when (view.findNavController().currentDestination!!.id) {
                        R.layout.fragment_news_list -> {
                            NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                                data
                            )
                        }
                        else -> {
                            NewsListInCategoryFragmentDirections.actionNewsListInCategoryFragmentToNewsDetailFragment(
                                data
                            )
                        }
                    }
                    view.findNavController().navigate(action)
                }
                is String -> {
                    val action =
                        NewsCategoryFragmentDirections.actionNewsCategoryFragmentToNewsListInCategoryFragment(
                            data
                        )
                    view.findNavController().navigate(action)
                }
            }
        }
    }
}