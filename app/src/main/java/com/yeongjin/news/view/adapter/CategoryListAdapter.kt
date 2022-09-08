package com.yeongjin.news.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yeongjin.news.data.model.Category
import com.yeongjin.news.databinding.ItemNewsCategoryBinding

class CategoryListAdapter: ListAdapter<Category, CategoryListAdapter.CategoryListViewHolder>(
    diffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder =
        CategoryListViewHolder(
            ItemNewsCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class CategoryListViewHolder(private val binding: ItemNewsCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem === newItem
            }
        }
    }
}