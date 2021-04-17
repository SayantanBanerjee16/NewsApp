package com.sayantanbanerjee.newsapp.presentation.di

import android.app.Application
import com.sayantanbanerjee.newsapp.domain.UseCase.GetNewsHeadlinesUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSavedNewsUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSearchedNewsUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.SaveNewsUseCase
import com.sayantanbanerjee.newsapp.presentation.viewmodelfactory.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    // provided the view model factory class for the NewsViewModelFactory
    @Singleton
    @Provides
    fun providesNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        )
    }
}
