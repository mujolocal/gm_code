package com.example.gm_coding.model

import java.io.Serializable

data class Track(val artistName:String,
                 val trackName: String,
                 val releaseDate: String,
                 val trackPrice:Float,
                 val primaryGenreName: String): Serializable
