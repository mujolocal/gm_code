package com.example.gm_coding.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.gm_coding.R
import com.example.gm_coding.databinding.FragmentLaunchBinding
import com.example.gm_coding.model.TrackResponse
import com.example.gm_coding.viewModel.LaunchViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi


class LaunchFragment : Fragment() {
    private val TAG = "LaunchFragment"
    lateinit var launchViewModel: LaunchViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLaunchBinding = FragmentLaunchBinding.inflate(
            inflater,
            container,
            false
        )

        launchViewModel  = ViewModelProvider(this).get(LaunchViewModel::class.java)
        binding.launchViewModel = launchViewModel
        launchViewModel.trackResponse.observe(viewLifecycleOwner){
            toArtistList(it)
        }

        return binding.root
    }



    fun toArtistList(trackResponse: TrackResponse){
        val action = LaunchFragmentDirections.actionLaunchFragmentToArtistListFragment(trackResponse)

        NavHostFragment.findNavController(this).navigate(action)
    }


}