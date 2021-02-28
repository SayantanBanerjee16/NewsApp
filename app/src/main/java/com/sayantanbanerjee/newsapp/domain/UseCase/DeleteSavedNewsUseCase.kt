package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}
