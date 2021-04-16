package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import com.sayantanbanerjee.newsapp.data.repository.NewsRepositoryImpl
import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    // provided the NewsRepositoryImpl(data->repository) which is called from the Use Cases
    @Singleton
    @Provides
    fun providesNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}
