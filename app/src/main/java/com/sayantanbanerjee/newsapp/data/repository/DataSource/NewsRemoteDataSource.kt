package com.sayantanbanerjee.newsapp.data.repository.DataSource

import com.sayantanbanerjee.newsapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>

    suspend fun getSearchedNews(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse>
}
