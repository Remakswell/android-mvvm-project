package com.example.shareplanet.data.network.api

import com.example.shareplanet.data.model.NasaDate
import com.example.shareplanet.data.model.NasaPhoto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    companion object {
        const val BASE_URL = "https://api.nasa.gov/EPIC/api/"
        const val API_KEY = "uNThvWrh6FILm45gVkesGPklMcyiGauwWRdfDGck"
    }

    @GET("natural/all")
    fun getDatesWithPhoto() : Single<List<NasaDate>>

    @GET("natural/date/{date}")
    fun getPhotosByDate(@Path("date") date: String) : Single<List<NasaPhoto>>
}