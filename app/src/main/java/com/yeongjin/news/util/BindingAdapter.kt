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
import com.yeongjin.news.view.categories.NewsListInCategoryFragment
import com.yeongjin.news.view.categories.NewsListInCategoryFragmentDirections
import com.yeongjin.news.view.newslist.NewsListFragment
import com.yeongjin.news.view.newslist.NewsListFragmentDirections
import com.yeongjin.news.view.saved.SavedNewsListFragmentDirections
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

    @BindingAdapter("android:navigateWithData", "android:fragment")
    @JvmStatic
    fun navigateWithData(view: ConstraintLayout, data: Any, fragment: String?) {
        view.setOnClickListener {
            when (data) {
                is News -> {
                    val action = when (fragment) {
                        NewsListFragment::class.java.simpleName -> {
                            NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(
                                data, data.title
                            )
                        }
                        NewsListInCategoryFragment::class.java.simpleName -> {
                            NewsListInCategoryFragmentDirections.actionNewsListInCategoryFragmentToNewsDetailFragment(
                                data,data.title
                            )
                        }
                        else -> {
                            SavedNewsListFragmentDirections.actionSavedNewsListFragmentToNewsDetailFragment(
                                data,data.title
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