package com.example.template.data.network

import com.example.template.data.network.api.ServiceApi
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val serviceApi: ServiceApi
) {
    fun getDates() = serviceApi.getDatesWithPhoto()
}