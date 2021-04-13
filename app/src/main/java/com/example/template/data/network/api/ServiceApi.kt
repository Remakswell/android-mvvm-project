package com.example.template.data.network.api

import com.example.template.data.model.NasaDate
import io.reactivex.Single
import retrofit2.http.GET

interface ServiceApi {

    companion object {
        const val BASE_URL = "https://api.nasa.gov/EPIC/api/"
        const val API_KEY = "uNThvWrh6FILm45gVkesGPklMcyiGauwWRdfDGck"
    }

    @GET("natural/all")
    fun getDatesWithPhoto() : Single<List<NasaDate>>
}