package com.yeongjin.news.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yeongjin.news.data.model.News
import com.yeongjin.news.databinding.ItemNewsListBinding

class NewsListPagingAdapter(private val fragment: String): PagingDataAdapter<News, NewsListPagingAdapter.NewsListViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder = NewsListViewHolder(
        ItemNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false), fragment
    )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class NewsListViewHolder(private val binding: ItemNewsListBinding, private val fragment: String) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.newsLayout.clipToOutline = true
            binding.news = news
            binding.fragment = fragment
        }
    }
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem === newItem
            }
        }
    }
}