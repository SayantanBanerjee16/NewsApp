package com.sayantanbanerjee.newsapp.data.repository.DataSourceImpl

import com.sayantanbanerjee.newsapp.data.api.NewsAPIService
import com.sayantanbanerjee.newsapp.data.model.APIResponse
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(country, searchedQuery, page)
    }

}
