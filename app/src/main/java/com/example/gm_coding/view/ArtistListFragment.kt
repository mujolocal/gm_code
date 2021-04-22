package com.example.gm_coding.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.compose.navArgument
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gm_coding.R
import com.example.gm_coding.adapters.TrackAdapter
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
        val trackAdapter = trackResponse.results?.let { TrackAdapter(it) }
        val recyclerView = binding.trackRv
        val linearLayoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = trackAdapter

        return binding.root
    }


}