package com.sayantanbanerjee.newsapp.presentation.di

import android.app.Application
import com.sayantanbanerjee.newsapp.domain.UseCase.GetNewsHeadlinesUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSearchedNewsUseCase
import com.sayantanbanerjee.newsapp.presentation.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class FactoryModule {

    // provided the view model factory class for the NewsViewModelFactory
    @Singleton
    @Provides
    fun providesNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase, getSearchedNewsUseCase)
    }
}
