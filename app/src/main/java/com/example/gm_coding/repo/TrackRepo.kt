package com.example.gm_coding.repo

import com.example.gm_coding.repo.remote.RetrofitInstance

object TrackRepo {

    val trackService = RetrofitInstance.trackService

    suspend fun getTrackResponse(term: String) = trackService.getTrackResponse2(term)
}