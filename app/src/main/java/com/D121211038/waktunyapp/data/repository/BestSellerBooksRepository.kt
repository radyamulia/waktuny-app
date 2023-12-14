package com.D121211038.waktunyapp.data.repository

import com.D121211038.waktunyapp.data.response.GetBestSellerBooksResponse
import com.D121211038.waktunyapp.data.source.remote.ApiService

class BestSellerBooksRepository(private val apiService: ApiService) {

    suspend fun getBestSellerBooksHardFiction(): GetBestSellerBooksResponse {
        return apiService.getBestSellerBooksHardFiction()
    }
    suspend fun getBestSellerBooksPrintFiction(): GetBestSellerBooksResponse {
        return apiService.getBestSellerBooksPrintFiction()
    }
    suspend fun getBestSellerBooksPaperbackFiction(): GetBestSellerBooksResponse {
        return apiService.getBestSellerBooksPaperbackFiction()
    }

}