package com.sayantanbanerjee.newsapp.data.repository.DataSource

import com.sayantanbanerjee.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)
    fun getSavedArticles() : Flow<List<Article>>
}