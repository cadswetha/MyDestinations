package com.cads.mydestinations.network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DestAPI {
    @GET("destination")
    suspend fun getDestinations() : List<Dest>

    @POST("destination")
    suspend fun postDestination(@Body destination: Dest) :Dest
}

object DestNetwork{
    const val buildURL = "http://10.0.2.2:9000/"
    val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(buildURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DestAPI::class.java)
    }
}