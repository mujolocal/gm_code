package com.example.gm_coding.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class LaunchViewModel:ViewModel() {
    private val TAG = "LaunchViewModel"

    fun getArtists(){
        Log.d(TAG, "getArtists: these artist be gotten")
    }
}