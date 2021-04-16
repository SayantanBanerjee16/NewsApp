package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun providesNewsAdapter() : NewsAdapter {
        return NewsAdapter()
    }
}
