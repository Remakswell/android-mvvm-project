package com.example.shareplanet.data

import com.example.shareplanet.data.local.LocalDataSource
import com.example.shareplanet.data.network.NetworkDataSource
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) {
    fun getInfo() = networkDataSource.getDates()
        .doOnSuccess {

        }

    fun getPhotos(date: String) = networkDataSource.getPhotos(date)
        .doOnSuccess {

        }
}