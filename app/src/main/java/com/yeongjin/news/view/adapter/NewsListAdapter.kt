package com.yeongjin.news.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yeongjin.news.data.model.News
import com.yeongjin.news.databinding.ItemNewsListBinding

class NewsListAdapter: ListAdapter<News, NewsListAdapter.NewsListViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder = NewsListViewHolder(
        ItemNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class NewsListViewHolder(private val binding: ItemNewsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.newsLayout.clipToOutline = true
            binding.news = news
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