package com.yeongjin.news.view.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsCategoryBinding
import com.yeongjin.news.global.base.BaseFragment

class NewsCategoryFragment : BaseFragment<FragmentNewsCategoryBinding>(R.layout.fragment_news_category) {
    override val TAG: String = NewsCategoryFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}