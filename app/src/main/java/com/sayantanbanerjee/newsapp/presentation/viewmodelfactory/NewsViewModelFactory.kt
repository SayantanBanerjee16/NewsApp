package com.sayantanbanerjee.newsapp.presentation.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sayantanbanerjee.newsapp.domain.UseCase.GetNewsHeadlinesUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSavedNewsUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSearchedNewsUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.SaveNewsUseCase
import com.sayantanbanerjee.newsapp.presentation.viewmodel.NewsViewModel

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        ) as T
    }
}
