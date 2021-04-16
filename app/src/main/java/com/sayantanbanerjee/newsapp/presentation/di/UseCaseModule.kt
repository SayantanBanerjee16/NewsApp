package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.domain.UseCase.GetNewsHeadlinesUseCase
import com.sayantanbanerjee.newsapp.domain.UseCase.GetSearchedNewsUseCase
import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    // provided the use-cases defined in the domain layer
    @Singleton
    @Provides
    fun providesGetNewsHeadlinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

}
