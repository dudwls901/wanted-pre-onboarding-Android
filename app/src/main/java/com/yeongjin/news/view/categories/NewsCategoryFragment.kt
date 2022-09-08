package com.yeongjin.news.view.categories

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.yeongjin.news.R
import com.yeongjin.news.data.model.Category
import com.yeongjin.news.databinding.FragmentNewsCategoryBinding
import com.yeongjin.news.global.Constants
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.view.adapter.CategoryListAdapter

class NewsCategoryFragment :
    BaseFragment<FragmentNewsCategoryBinding>(R.layout.fragment_news_category) {
    override val TAG: String = NewsCategoryFragment::class.java.simpleName

    private val adapter: CategoryListAdapter by lazy { CategoryListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding){
        newsCategoryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        newsCategoryRecyclerView.adapter = adapter
        adapter.submitList(getCategoryList())
    }


    private fun getCategoryList(): List<Category> = listOf(
        Category(R.drawable.ic_business_32, Constants.CATEGORY.BUSINESS),
        Category(R.drawable.ic_entertainment_32, Constants.CATEGORY.ENTERTAINMENT),
        Category(R.drawable.ic_general_32, Constants.CATEGORY.GENERAL),
        Category(R.drawable.ic_health_32, Constants.CATEGORY.HEALTH),
        Category(R.drawable.ic_science_24, Constants.CATEGORY.SCIENCE),
        Category(R.drawable.ic_sports_28, Constants.CATEGORY.SPORTS),
        Category(R.drawable.ic_technology_28, Constants.CATEGORY.TECHNOLOGY)
    )
}