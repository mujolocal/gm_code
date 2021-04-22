package com.example.gm_coding.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class TrackResponse(
    @Json(name = "resultCount")
    val resultCount: Int?,
    @Json(name = "results")
    val results: List<Result>?
) : Parcelable