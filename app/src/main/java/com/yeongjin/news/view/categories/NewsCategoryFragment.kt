package com.yeongjin.news.view.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.yeongjin.news.R
import com.yeongjin.news.data.model.Category
import com.yeongjin.news.databinding.FragmentNewsCategoryBinding
import com.yeongjin.news.global.Constants
import com.yeongjin.news.global.base.BaseFragment

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
        Category(R.drawable.ic_business_32, Constants.Category.BUSINESS.name.lowercase()),
        Category(R.drawable.ic_entertainment_32, Constants.Category.ENTERTAINMENT.name.lowercase()),
        Category(R.drawable.ic_general_32, Constants.Category.GENERAL.name.lowercase()),
        Category(R.drawable.ic_health_32, Constants.Category.HELATH.name.lowercase()),
        Category(R.drawable.ic_science_24, Constants.Category.SCIENCE.name.lowercase()),
        Category(R.drawable.ic_sports_28, Constants.Category.SPORTS.name.lowercase()),
        Category(R.drawable.ic_technology_28, Constants.Category.TECHNOLOGY.name.lowercase())
    )
}