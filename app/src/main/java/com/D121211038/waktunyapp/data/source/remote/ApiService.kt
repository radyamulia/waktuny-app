package com.D121211038.waktunyapp.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query
import com.D121211038.waktunyapp.BuildConfig
import com.D121211038.waktunyapp.data.response.GetBestSellerBooksResponse
import com.D121211038.waktunyapp.data.response.GetPopularArticlesResponse
import com.D121211038.waktunyapp.data.response.GetTimesWireResponse
import com.D121211038.waktunyapp.data.response.GetTopStoriesResponse
import retrofit2.Call
import retrofit2.http.Path

interface ApiService {

    // Get Top Stories
    @GET("svc/topstories/v2/world.json")
    suspend fun getTopStories(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetTopStoriesResponse

    // Get Popular Articles
    @GET("svc/mostpopular/v2/emailed/7.json")
    suspend fun getPopularArticles(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetPopularArticlesResponse


    // Get Times Wire
    @GET("svc/news/v3/content/all/all.json")
    suspend fun getTimesWire(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetTimesWireResponse

    // Get Best Seller Books
//    @GET("svc/books/v3/lists/current/{list}.json")
//    suspend fun getBestSellerBooks(
//        @Path(value = "list", encoded = true)
//        @Query("api-key") apiKey: String = BuildConfig.API_KEY
//        String list
//    )

    // Get Best Seller Books (Print and E-book Fiction)
    @GET("svc/books/v3/lists/current/combined-print-and-e-book-fiction.json")
    suspend fun getBestSellerBooksPrintFiction(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetBestSellerBooksResponse

    // Get Best Seller Books (Hardcover Fiction)
    @GET("svc/books/v3/lists/current/hardcover-fiction.json")
    suspend fun getBestSellerBooksHardFiction(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetBestSellerBooksResponse

    // Get Best Seller Books (Hardcover Fiction)
    @GET("svc/books/v3/lists/current/trade-fiction-paperback.json")
    suspend fun getBestSellerBooksPaperbackFiction(
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): GetBestSellerBooksResponse

}