package com.example.gm_coding.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class TrackResponse(
    @Json(name = "resultCount")
    val resultCount: Int?,
    @Json(name = "results")
    val results: List<Result>?
):Serializable