package com.sayantanbanerjee.newsapp.data.repository

import com.sayantanbanerjee.newsapp.data.model.APIResponse
import com.sayantanbanerjee.newsapp.data.model.Article
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import com.sayantanbanerjee.newsapp.data.util.Resource
import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}
