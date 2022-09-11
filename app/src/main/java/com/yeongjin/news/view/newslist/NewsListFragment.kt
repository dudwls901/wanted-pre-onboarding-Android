package com.yeongjin.news.view.newslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsListBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.view.adapter.NewsListAdapter
import com.yeongjin.news.viewmodel.TopNewsListViewModel

class NewsListFragment : BaseFragment<FragmentNewsListBinding>(R.layout.fragment_news_list) {
    override val TAG: String = NewsListFragment::class.java.simpleName

    private val adapter: NewsListAdapter by lazy { NewsListAdapter(NewsListFragment::class.java.simpleName) }
    private val topNewsListViewModel: TopNewsListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeDatas()

    }
    private fun initViews() = with(binding){
        newsListRecyclerView.adapter = adapter
        topNewsListViewModel.getNews()
    }

    private fun observeDatas() {
        topNewsListViewModel.newsList.observe(viewLifecycleOwner){ newsList ->
            adapter.submitList(newsList)
        }
    }

}