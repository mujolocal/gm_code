package com.example.gm_coding.viewModel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
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
    var artistName = ObservableField<String>()
    var spinnerVisibility = ObservableField(View.INVISIBLE)

    private val _trackResponse = MutableLiveData<TrackResponse>()
    val trackResponse: LiveData<TrackResponse>
        get() = _trackResponse

    private val _switchToArtistListFragment = MutableLiveData<Boolean>()
    val switchToArtistListFragment : LiveData<Boolean>
        get() = _switchToArtistListFragment

    fun getArtists( ){
        spinnerVisibility.set(View.VISIBLE)
        Log.d(TAG, "getArtists: these artist be gotten")
        viewModelScope.launch(Dispatchers.Default){
            val callback : Callback<TrackResponse> = object: Callback<TrackResponse> {
                override fun onResponse(
                    call: Call<TrackResponse>,
                    response: Response<TrackResponse>
                ) {
                    _trackResponse.value =  response.body()
                    _switchToArtistListFragment.value = true
                }

                override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: " + t)
                }

            }
            TrackRepo.trackService.getTrackResponse(artistName.get() ?: "Billy Joel").enqueue(
                callback
            )
            spinnerVisibility.set(View.INVISIBLE)
        }

    }
}