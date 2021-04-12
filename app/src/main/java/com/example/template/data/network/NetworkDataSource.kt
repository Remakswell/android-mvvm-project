package com.example.template.data.network

import com.example.template.data.network.web.NetworkFaker
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val networkFaker: NetworkFaker
) {
    fun getSomeNetworkData() = networkFaker.getSomeData()
}