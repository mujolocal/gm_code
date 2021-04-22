package com.example.gm_coding.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.compose.navArgument
import androidx.navigation.fragment.navArgs
import com.example.gm_coding.R
import com.example.gm_coding.databinding.FragmentArtistListBinding
import com.example.gm_coding.model.TrackResponse
import com.squareup.moshi.Moshi


class ArtistListFragment : Fragment() {
    private  val TAG = "ArtistListFragment"
    val safeArgs : ArtistListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentArtistListBinding.inflate(inflater,container,false)
        val trackResponse = safeArgs.trackResponse
        Log.d(TAG, "onCreateView: $trackResponse")
        binding.txtTv.text = trackResponse.toString()
        return binding.root
    }


}