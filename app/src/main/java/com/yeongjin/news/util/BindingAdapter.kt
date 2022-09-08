package com.yeongjin.news.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yeongjin.news.R

object BindingAdapter {

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun setImageUri(view: ImageView, imageUrl: String){
        view.clipToOutline = true
        Glide.with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_news_24)
            .into(view)
    }
}