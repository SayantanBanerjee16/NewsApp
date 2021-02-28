package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}
