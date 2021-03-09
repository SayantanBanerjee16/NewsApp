package com.sayantanbanerjee.newsapp.data.repository.DataSourceImpl

import com.sayantanbanerjee.newsapp.data.api.NewsAPIService
import com.sayantanbanerjee.newsapp.data.model.APIResponse
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getHeadlines(country, page)
    }
}
