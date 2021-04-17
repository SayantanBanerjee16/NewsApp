package com.sayantanbanerjee.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sayantanbanerjee.newsapp.R
import com.sayantanbanerjee.newsapp.databinding.ActivityMainBinding
import com.sayantanbanerjee.newsapp.presentation.adapter.NewsAdapter
import com.sayantanbanerjee.newsapp.presentation.viewmodel.NewsViewModel
import com.sayantanbanerjee.newsapp.presentation.viewmodelfactory.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory

    lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var newsAdapter : NewsAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

        // setting up the navigation fragment and also linking it to the navigation controller
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bnvNews.setupWithNavController(
            navController
        )
    }
}
