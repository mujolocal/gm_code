package com.example.gm_coding.repo

import com.example.gm_coding.model.TrackResponse
import com.example.gm_coding.repo.remote.RetrofitInstance

object TrackRepo {
    val trackService =  RetrofitInstance.trackService

}