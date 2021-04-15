package com.sayantanbanerjee.newsapp.presentation.di

import com.sayantanbanerjee.newsapp.BuildConfig
import com.sayantanbanerjee.newsapp.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetModule {

    // provide the retrofit service using the base url
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    // provided the NewsApiService defined in (data->api->NewsAPIService) used in NewsRemoteDataSourceImpl(data->repository->DataSourceImpl)
    @Singleton
    @Provides
    fun providesNewsAPIService(retrofit: Retrofit) : NewsAPIService{
        return retrofit.create(NewsAPIService::class.java)
    }

}
