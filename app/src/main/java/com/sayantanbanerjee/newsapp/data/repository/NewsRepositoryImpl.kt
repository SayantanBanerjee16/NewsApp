package com.sayantanbanerjee.newsapp.data.repository

import com.sayantanbanerjee.newsapp.data.model.APIResponse
import com.sayantanbanerjee.newsapp.data.model.Article
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsLocalDataSource
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsRemoteDataSource
import com.sayantanbanerjee.newsapp.data.util.Resource
import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }


    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticlesToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}
