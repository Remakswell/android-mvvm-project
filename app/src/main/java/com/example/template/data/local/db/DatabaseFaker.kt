package com.example.template.data.local.db

import javax.inject.Inject

class DatabaseFaker @Inject constructor() {
    //TODO use room
    fun getSomeData() = "Data from DB"
}