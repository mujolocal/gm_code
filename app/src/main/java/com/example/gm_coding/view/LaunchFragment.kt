package com.example.gm_coding.view

import android.content.Context
import android.os.Bundle
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
    lateinit var launchViewModel: LaunchViewModel
    val sharedPref = this.activity?.getPreferences(Context.MODE_PRIVATE)
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(TrackResponse::class.java)


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
            with(sharedPref?.edit()){
                this?.putString(getString(R.string.artists_songs),jsonAdapter.toJson(it) )
            }
        }
        launchViewModel.switchToArtistListFragment.observe(viewLifecycleOwner){
            if (it){
                toArtistList()
            }
        }



        return binding.root
    }



    fun toArtistList(){
        val action = LaunchFragmentDirections.actionLaunchFragmentToArtistListFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }


}