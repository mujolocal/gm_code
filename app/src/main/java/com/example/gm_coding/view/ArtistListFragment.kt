package com.example.gm_coding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gm_coding.R
import com.example.gm_coding.databinding.FragmentArtistListBinding


class ArtistListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentArtistListBinding.inflate(inflater,container,false)

        return binding.root
    }


}