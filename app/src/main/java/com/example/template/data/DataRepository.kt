package com.example.template.data

import com.example.template.data.local.LocalDataSource
import com.example.template.data.network.NetworkDataSource
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) {
    fun getInfo() : String {
        return if (networkDataSource.getSomeNetworkData().isEmpty()) {
            localDataSource.getSomeLocalData()
            // TODO save to DB
        } else {
            networkDataSource.getSomeNetworkData()
        }
    }
}