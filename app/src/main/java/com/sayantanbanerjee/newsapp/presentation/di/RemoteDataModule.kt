package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.data.api.NewsAPIService
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import com.sayantanbanerjee.newsapp.data.repository.DataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule {

    // provided the NewsRemoteDataSourceImpl(data->repository->DataSourceImpl) which is called from NewsRepositoryImpl(data->repository)
    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}
