package com.example.gm_coding.repo.remote

import com.example.gm_coding.model.TrackResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface TrackService {

    @GET("search/{mike}")
    fun getTrackResponse():Call<TrackResponse>
}