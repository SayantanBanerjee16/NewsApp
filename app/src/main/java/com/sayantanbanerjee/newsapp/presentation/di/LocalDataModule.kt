package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.data.db.ArticleDAO
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsLocalDataSource
import com.sayantanbanerjee.newsapp.data.repository.DataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }

}
