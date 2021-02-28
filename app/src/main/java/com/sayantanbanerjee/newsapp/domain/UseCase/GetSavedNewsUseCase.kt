package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}
