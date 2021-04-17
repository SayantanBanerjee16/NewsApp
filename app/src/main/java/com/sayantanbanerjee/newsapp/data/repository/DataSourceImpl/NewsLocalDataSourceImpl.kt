package com.sayantanbanerjee.newsapp.data.repository.DataSourceImpl

import com.sayantanbanerjee.newsapp.data.db.ArticleDAO
import com.sayantanbanerjee.newsapp.data.model.Article
import com.sayantanbanerjee.newsapp.data.repository.DataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao : ArticleDAO
) : NewsLocalDataSource {
    override suspend fun saveArticlesToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }
}