package com.sayantanbanerjee.newsapp.data.repository.DataSource

import com.sayantanbanerjee.newsapp.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)
}