package com.sayantanbanerjee.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.sayantanbanerjee.newsapp.databinding.FragmentInfoBinding
import com.sayantanbanerjee.newsapp.presentation.MainActivity
import com.sayantanbanerjee.newsapp.presentation.viewmodel.NewsViewModel

class InfoFragment : Fragment() {

    private lateinit var fragmentInfoBinding: FragmentInfoBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedItem
        val articleURL = article.url
        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if (articleURL != null) {
                loadUrl(articleURL)
            }
        }

        fragmentInfoBinding.floatingActionButton.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Saved Successfully", Snackbar.LENGTH_LONG).show()
        }

    }
}