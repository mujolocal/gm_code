package com.example.gm_coding.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://itunes.apple.com/"

    private val client = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }.let { loginIntercept -> OkHttpClient.Builder().addInterceptor(loginIntercept).build() }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val trackService: TrackService by lazy { retrofit.create(TrackService::class.java) }
}