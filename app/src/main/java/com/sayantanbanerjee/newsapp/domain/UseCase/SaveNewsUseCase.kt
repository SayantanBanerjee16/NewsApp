package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}
