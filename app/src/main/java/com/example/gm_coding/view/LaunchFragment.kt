package com.example.gm_coding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.gm_coding.R
import com.example.gm_coding.databinding.ActivityMainBinding
import com.example.gm_coding.databinding.FragmentLaunchBinding
import com.example.gm_coding.viewModel.LaunchViewModel


class LaunchFragment : Fragment() {
    lateinit var launchViewModel: LaunchViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLaunchBinding = FragmentLaunchBinding.inflate(inflater,container,false)
        launchViewModel  = ViewModelProvider(this).get(LaunchViewModel::class.java)
        binding.launchViewModel = launchViewModel
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