package com.example.gm_coding.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gm_coding.R
import com.example.gm_coding.adapters.TrackAdapter
import com.example.gm_coding.databinding.FragmentArtistListBinding


class ArtistListFragment : Fragment(R.layout.fragment_artist_list) {

    private val args: ArtistListFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentArtistListBinding.bind(view).apply {
            with(trackRv) {
                layoutManager = LinearLayoutManager(context)
                adapter = TrackAdapter(args.trackResponse.toList())
            }
        }
    }

}