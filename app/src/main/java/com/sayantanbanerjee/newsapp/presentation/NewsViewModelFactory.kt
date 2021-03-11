package com.sayantanbanerjee.newsapp.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sayantanbanerjee.newsapp.domain.UseCase.GetNewsHeadlinesUseCase
import com.sayantanbanerjee.newsapp.presentation.viewmodel.NewsViewModel

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(app, getNewsHeadlinesUseCase) as T
    }
}
