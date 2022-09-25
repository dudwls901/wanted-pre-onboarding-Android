package com.yeongjin.news.view.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentCategoryNewsListBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.view.adapter.NewsListPagingAdapter
import com.yeongjin.news.viewmodel.NewsListIntCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsListInCategoryFragment :
    BaseFragment<FragmentCategoryNewsListBinding>(R.layout.fragment_category_news_list) {
    override val TAG: String = NewsListInCategoryFragment::class.java.simpleName

    private val adapter: NewsListPagingAdapter by lazy {
        NewsListPagingAdapter(
            NewsListInCategoryFragment::class.java.simpleName
        )
    }
    private val newsListViewModel: NewsListIntCategoryViewModel by viewModels()
    private val args by navArgs<NewsListInCategoryFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeDatas()

    }

    private fun initViews() = with(binding) {
        newsListRecyclerView.adapter = adapter
        newsListViewModel.getCategoryNews(args.category)
    }

    private fun observeDatas() {
        newsListViewModel.pagingCategoryNewsList.observe(viewLifecycleOwner) { newsList ->
            lifecycleScope.launch {
                adapter.submitData(newsList)
            }
        }
    }

}