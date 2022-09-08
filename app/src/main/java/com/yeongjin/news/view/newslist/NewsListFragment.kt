package com.yeongjin.news.view.newslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsListBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.viewmodel.MainViewModel

class NewsListFragment : BaseFragment<FragmentNewsListBinding>(R.layout.fragment_news_list) {
    override val TAG: String = NewsListFragment::class.java.simpleName

    private val adapter: NewsListAdapter by lazy { NewsListAdapter() }
    private val mainViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeDatas()

    }
    private fun initViews() = with(binding){
        newsListRecyclerView.adapter = adapter
        mainViewModel.getNews()
    }

    private fun observeDatas() {
        mainViewModel.newsList.observe(viewLifecycleOwner){ newsList ->
            adapter.submitList(newsList)
        }
    }

}