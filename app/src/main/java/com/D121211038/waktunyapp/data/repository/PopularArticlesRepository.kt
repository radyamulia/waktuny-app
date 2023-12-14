package com.D121211038.waktunyapp.data.repository

import com.D121211038.waktunyapp.data.response.GetPopularArticlesResponse
import com.D121211038.waktunyapp.data.source.remote.ApiService

class PopularArticlesRepository(private val apiService: ApiService) {

    suspend fun getPopularArticles(): GetPopularArticlesResponse {
        return apiService.getPopularArticles()
    }

}