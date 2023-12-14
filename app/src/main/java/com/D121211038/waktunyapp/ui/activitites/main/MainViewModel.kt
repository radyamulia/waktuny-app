package com.D121211038.waktunyapp.ui.activitites.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211038.waktunyapp.MyApplication
import com.D121211038.waktunyapp.data.models.BestSellerBook
import com.D121211038.waktunyapp.data.models.TimesWire
import com.D121211038.waktunyapp.data.models.TopStory
import com.D121211038.waktunyapp.data.repository.BestSellerBooksRepository
import com.D121211038.waktunyapp.data.repository.TimesWireRepository
import com.D121211038.waktunyapp.data.repository.TopStoriesRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val timesWire: List<TimesWire>, val topStories: List<TopStory>, val books: List<BestSellerBook>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(
    private val timesWireRepository: TimesWireRepository,
    private val topStoriesRepository: TopStoriesRepository,
    private val bestSellerBooksRepository: BestSellerBooksRepository
): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    private var timesWireResult= mutableListOf<TimesWire>()
    private var topStoriesResult = mutableListOf<TopStory>()
    private var bestSellerBooksResult = mutableListOf<BestSellerBook>()

    suspend fun getTimesWire() {
        try {
            val result = timesWireRepository.getTimesWire()
            Log.d("MainViewModel", "getTimesWire: ${result}")
            timesWireResult.addAll(result.results.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewModel", "getTimesWire error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    suspend fun getTopStories() {
        try {
            val result = topStoriesRepository.getTopStories()
            Log.d("MainViewModel", "getTopStories: ${result}")
            topStoriesResult.addAll(result.results.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewModel", "getNews error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    suspend fun getBestSellerBooks() {
        try {
            val result = bestSellerBooksRepository.getBestSellerBooksPrintFiction()
            Log.d("MainViewModel", "getBestSellerBooks: ${result.results?.books?.size}")
            bestSellerBooksResult.addAll(result.results?.books.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewModel", "getBestSellerBooks error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }


    fun fetchAllData() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            getTimesWire()
            getTopStories()
            getBestSellerBooks()
            mainUiState = MainUiState.Success(timesWireResult, topStoriesResult, bestSellerBooksResult)
        } catch (e: IOException) {
            Log.d("MainViewModel", "fetchAllData error:  ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        fetchAllData()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val timesWireRepository = application.container.timesWireRepository
                val topStoriesRepository = application.container.topStoriesRepository
                val bestSellerBooksRepository = application.container.bestSellerBooksRepository
                MainViewModel(timesWireRepository, topStoriesRepository, bestSellerBooksRepository)
            }
        }
    }
}