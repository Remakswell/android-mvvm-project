package com.example.template.data

import com.example.template.data.local.LocalDataSource
import com.example.template.data.network.NetworkDataSource
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