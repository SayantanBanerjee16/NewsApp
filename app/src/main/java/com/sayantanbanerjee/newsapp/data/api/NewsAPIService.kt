package com.sayantanbanerjee.newsapp.data.api

import com.sayantanbanerjee.newsapp.BuildConfig
import com.sayantanbanerjee.newsapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}
