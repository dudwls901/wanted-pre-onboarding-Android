package com.yeongjin.news.view.saved

import android.os.Bundle
import android.view.View
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsListBinding
import com.yeongjin.news.databinding.FragmentSavedNewsListBinding
import com.yeongjin.news.global.base.BaseFragment

class SavedNewsListFragment : BaseFragment<FragmentSavedNewsListBinding>(R.layout.fragment_news_list) {
    override val TAG: String = SavedNewsListFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}