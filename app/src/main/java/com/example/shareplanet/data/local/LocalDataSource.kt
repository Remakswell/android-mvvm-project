package com.example.shareplanet.data.local

import com.example.shareplanet.data.local.db.DatabaseFaker
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val databaseFaker: DatabaseFaker
) {
    fun getSomeLocalData() = databaseFaker.getSomeData()
}