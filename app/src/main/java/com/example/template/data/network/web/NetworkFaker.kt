package com.example.template.data.network.web

import javax.inject.Inject

class NetworkFaker @Inject constructor() {
    //TODO use retrofit
    fun getSomeData() = "Data from Network"
}