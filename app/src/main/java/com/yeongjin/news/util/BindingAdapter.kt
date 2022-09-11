package com.yeongjin.news.util

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
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

    @BindingAdapter("android:emptyData")
    @JvmStatic
    fun emptyData(view: TextView, newsList: List<News>?){
        if(newsList == null || newsList.isEmpty()){
            view.visibility = View.VISIBLE
        }else{
            view.visibility = View.GONE
        }

    }

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun setImageUri(view: ImageView, imageUrl: Any?) {
        Glide.with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_news_24)
            .into(view)
    }

    @BindingAdapter("android:likeButtonDrawable")
    @JvmStatic
    fun setLikeButtonDrawable(view: ImageView, liked: Boolean) {
        if(liked){
            view.setImageResource(R.drawable.ic_star_yellow_24)
        } else{
            view.setImageResource(R.drawable.ic_star_border_24)
        }
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