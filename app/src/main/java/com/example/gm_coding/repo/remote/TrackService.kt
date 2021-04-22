package com.example.gm_coding.repo.remote

import com.example.gm_coding.model.TrackResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface TrackService {

    @GET("search")
    fun getTrackResponse(@Query("term") term: String):Call<TrackResponse>

    @GET("search")
    suspend fun getTrackResponse2(@Query("term") term: String): TrackResponse
}