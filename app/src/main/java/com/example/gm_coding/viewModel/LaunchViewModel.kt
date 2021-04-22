package com.example.gm_coding.viewModel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gm_coding.model.Result
import com.example.gm_coding.repo.TrackRepo
import com.example.gm_coding.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LaunchViewModel : ViewModel() {
    private val TAG = "LaunchViewModel"
    var artistName = ObservableField<String>()

    private val _apiState = MutableLiveData<ApiState<List<Result>>>()
    val apiState: LiveData<ApiState<List<Result>>>
        get() = _apiState

    fun getArtists() {
        Log.d(TAG, "getArtists: these artist be gotten")
        viewModelScope.launch(Dispatchers.IO) {
            val state = artistName.get()?.let { query ->
                _apiState.postValue(ApiState.Loading)
                try {
                    val tracks = TrackRepo.getTrackResponse(query).results
                    if (tracks.isNullOrEmpty()) ApiState.Error("No results found for $query")
                    else ApiState.Success(tracks)
                } catch (ex: Exception) {
                    ApiState.Error("Network error, please try again.")
                }

            } ?: ApiState.Error("Please enter a valid query.")
            _apiState.postValue(state)
        }

    }

    fun toggleCompletedState() {
        _apiState.value = ApiState.Completed
    }
}