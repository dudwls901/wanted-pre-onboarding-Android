package com.yeongjin.news.view.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentCategoryNewsListBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.view.adapter.NewsListAdapter
import com.yeongjin.news.view.newslist.NewsListFragment
import com.yeongjin.news.viewmodel.NewsListIntCategoryViewModel

//todo NewsListFragment 추상화
class NewsListInCategoryFragment : BaseFragment<FragmentCategoryNewsListBinding>(R.layout.fragment_category_news_list) {
    override val TAG: String = NewsListInCategoryFragment::class.java.simpleName

    private val adapter: NewsListAdapter by lazy { NewsListAdapter(NewsListInCategoryFragment::class.java.simpleName) }
    private val newsListViewModel: NewsListIntCategoryViewModel by viewModels()
    private val args by navArgs<NewsListInCategoryFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeDatas()

    }
    private fun initViews() = with(binding){
        newsListRecyclerView.adapter = adapter
        newsListViewModel.getCategoryNews(args.category)
    }

    private fun observeDatas() {
        newsListViewModel.newsList.observe(viewLifecycleOwner){ newsList ->
            adapter.submitList(newsList)
        }
    }

}