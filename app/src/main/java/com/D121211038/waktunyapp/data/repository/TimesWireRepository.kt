package com.D121211038.waktunyapp.data.repository

import com.D121211038.waktunyapp.data.response.GetTimesWireResponse
import com.D121211038.waktunyapp.data.source.remote.ApiService

class TimesWireRepository(private val apiService: ApiService) {

    suspend fun getTimesWire(): GetTimesWireResponse {
        return apiService.getTimesWire();
    }

}