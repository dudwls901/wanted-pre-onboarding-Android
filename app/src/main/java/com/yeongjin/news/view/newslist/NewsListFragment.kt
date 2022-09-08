package com.yeongjin.news.view.newslist

import android.os.Bundle
import android.view.View
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsListBinding
import com.yeongjin.news.global.base.BaseFragment

class NewsListFragment : BaseFragment<FragmentNewsListBinding>(R.layout.fragment_news_list) {
    override val TAG: String = NewsListFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}