package com.example.template.data.local

import com.example.template.data.local.db.DatabaseFaker
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val databaseFaker: DatabaseFaker
) {
    fun getSomeLocalData() = databaseFaker.getSomeData()
}