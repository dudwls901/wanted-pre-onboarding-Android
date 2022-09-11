package com.yeongjin.news.view.saved

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsListBinding
import com.yeongjin.news.databinding.FragmentSavedNewsListBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.view.adapter.NewsListAdapter
import com.yeongjin.news.viewmodel.SavedNewsListViewModel

class SavedNewsListFragment : BaseFragment<FragmentSavedNewsListBinding>(R.layout.fragment_saved_news_list) {
    override val TAG: String = SavedNewsListFragment::class.java.simpleName

    private val adapter: NewsListAdapter by lazy { NewsListAdapter(SavedNewsListFragment::class.java.simpleName) }
    private val savedNewsListViewModel: SavedNewsListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = savedNewsListViewModel
        initViews()
        observeDatas()
    }

    private fun initViews() = with(binding){
        newsListRecyclerView.adapter = adapter
    }

    private fun observeDatas() {
        savedNewsListViewModel.newsList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

}