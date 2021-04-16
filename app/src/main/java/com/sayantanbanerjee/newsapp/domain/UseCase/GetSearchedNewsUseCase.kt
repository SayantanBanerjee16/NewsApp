package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.data.model.APIResponse
import com.sayantanbanerjee.newsapp.data.util.Resource
import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}
