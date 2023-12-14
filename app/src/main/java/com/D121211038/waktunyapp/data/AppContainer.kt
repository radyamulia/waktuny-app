package com.D121211038.waktunyapp.data

import com.D121211038.waktunyapp.data.repository.BestSellerBooksRepository
import com.D121211038.waktunyapp.data.repository.PopularArticlesRepository
import com.D121211038.waktunyapp.data.repository.TimesWireRepository
import com.D121211038.waktunyapp.data.repository.TopStoriesRepository
import com.D121211038.waktunyapp.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val bestSellerBooksRepository: BestSellerBooksRepository
    val popularArticlesRepository: PopularArticlesRepository
    val timesWireRepository: TimesWireRepository
    val topStoriesRepository: TopStoriesRepository
}

class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://api.nytimes.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val bestSellerBooksRepository: BestSellerBooksRepository
        get() = BestSellerBooksRepository(retrofitService)
    override val popularArticlesRepository: PopularArticlesRepository
        get() = PopularArticlesRepository(retrofitService)
    override val timesWireRepository: TimesWireRepository
        get() = TimesWireRepository(retrofitService)
    override val topStoriesRepository: TopStoriesRepository
        get() = TopStoriesRepository(retrofitService)
}