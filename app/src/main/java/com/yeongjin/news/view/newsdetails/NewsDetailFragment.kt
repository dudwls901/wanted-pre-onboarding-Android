package com.yeongjin.news.view.newsdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.yeongjin.news.R
import com.yeongjin.news.databinding.FragmentNewsDetailBinding
import com.yeongjin.news.global.base.BaseFragment
import com.yeongjin.news.viewmodel.SavedNewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(R.layout.fragment_news_detail) {
    override val TAG: String = NewsDetailFragment::class.java.simpleName

    private val savedNewsListViewModel: SavedNewsListViewModel by activityViewModels()
    private val args by navArgs<NewsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = savedNewsListViewModel
        savedNewsListViewModel.setNews(args.news)
        binding.newsImageView.clipToOutline = true

    }

}