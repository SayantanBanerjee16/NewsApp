package com.sayantanbanerjee.newsapp.domain.UseCase

import com.sayantanbanerjee.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository){
}
