package com.example.gm_coding.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gm_coding.model.TrackResponse
import com.example.gm_coding.repo.TrackRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchViewModel:ViewModel() {
    private val TAG = "LaunchViewModel"

    private val _trackResponse = MutableLiveData<TrackResponse>()

    val trackResponse: LiveData<TrackResponse>
        get() = _trackResponse

    fun getArtists(){
        Log.d(TAG, "getArtists: these artist be gotten")
        viewModelScope.launch(Dispatchers.Default){
            val callback : Callback<TrackResponse> = object: Callback<TrackResponse> {
                override fun onResponse(
                    call: Call<TrackResponse>,
                    response: Response<TrackResponse>
                ) {
                    _trackResponse.value =  response.body()
                }

                override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: "+t)
                }

            }
            TrackRepo.trackService.getTrackResponse().enqueue(callback)
        }
    }
}