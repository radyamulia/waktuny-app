package com.D121211038.waktunyapp.data.repository

import com.D121211038.waktunyapp.data.response.GetTopStoriesResponse
import com.D121211038.waktunyapp.data.source.remote.ApiService

class TopStoriesRepository(private val apiService: ApiService) {

    suspend fun getTopStories(): GetTopStoriesResponse {
        return apiService.getTopStories()
    }

}